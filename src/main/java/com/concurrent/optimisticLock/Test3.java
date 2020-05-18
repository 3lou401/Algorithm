package com.concurrent.optimisticLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/24
 * Time: 16:28
 * Description: ABA
 */
@Slf4j(topic = "c.Test3")
public class Test3 {
    static AtomicReference<String> ref = new AtomicReference<>("A");
    public static void main(String[] args) throws InterruptedException {
        log.debug("main start");
        String prev = ref.get();
        other();
        Thread.sleep(1000);
        log.debug("change a -> c {}",
                ref.compareAndSet("A","C"));
        /*
             16:33:18.095 [main] c.Test3 -main start
            16:33:18.140 [t2] c.Test3 -change B->A true
            16:33:18.139 [t1] c.Test3 -change A->B true
            16:33:19.140 [main] c.Test3 -change a -> c true  可以修改成功
         */

    }

    private static void other() {
        new Thread(()->{
            log.debug("change A->B {}",
                    ref.compareAndSet(ref.get(),"B"));
        },"t1").start();
        new Thread(()->{
            log.debug("change B->A {}",
                    ref.compareAndSet(ref.get(),"A"));
        },"t2").start();
    }
}
