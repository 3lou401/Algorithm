package com.concurrent.optimisticLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/24
 * Time: 16:41
 * Description: ABA - 解决方式 -
 */
@Slf4j(topic = "c.Test4")
public class Test4 {
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A",0);

    public static void main(String[] args) throws InterruptedException {
        log.debug("main start");
        String prev = ref.getReference();
        int stamp =  ref.getStamp();
        other();
        Thread.sleep(1000);
        log.debug("stamp {}",stamp);
        log.debug("change a -> c {}",
                ref.compareAndSet("A","C",stamp,stamp+1));
    }

    private static void other() {
        new Thread(()->{
            int stamp =  ref.getStamp();
            log.debug("stamp {}",stamp);
            log.debug("change A->B {}",
                    ref.compareAndSet(ref.getReference(),"B",stamp,stamp+1));
        },"t1").start();
        new Thread(()->{
            int stamp =  ref.getStamp();
            log.debug("stamp {}",stamp);
            log.debug("change B->A {}",
                    ref.compareAndSet(ref.getReference(),"A",stamp,stamp+1));
        },"t2").start();
    }
}
