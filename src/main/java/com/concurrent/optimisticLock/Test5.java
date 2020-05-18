package com.concurrent.optimisticLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/24
 * Time: 16:51
 * Description: ABA -
 */
@Slf4j(topic = "c.Test5")
public class Test5 {
    public static void main(String[] args) {
        GarbageBag bag = new GarbageBag("装满了垃圾");
        AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<>(bag,true);

        //主线程修改前，其他线程做了ABA
        new Thread(()->{
            boolean isMark = ref.isMarked();
            log.debug("是否为空 {}",isMark);
            log.debug("更换结果  {}", ref.compareAndSet(bag,new GarbageBag("空垃圾袋"),true,false));
        },"t1").start();

        //主线程进行修改 开始空垃圾袋，没有修改标记为true , 如果没有被修改，可以用true表示空垃圾袋
        boolean isempty = ref.isMarked();
        log.debug("是否为空 {}",isempty);
        boolean modify = ref.compareAndSet(bag,new GarbageBag("空垃圾袋"),true,false);
        log.debug("更换结果 {}",modify);
        /*
                17:03:20.167 [t1] c.Test5 -是否为空 true
                17:03:20.167 [main] c.Test5 -是否为空 true
                17:03:20.172 [t1] c.Test5 -更换结果  true
                17:03:20.172 [main] c.Test5 -更换结果 false // t1改了，主线程就无法修改了
         */
    }
}
class GarbageBag{
    private String name;

    public GarbageBag(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this+"-"+this.name;
    }
}
