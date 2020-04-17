package com.concurrent.lockSupport;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 16:18
 * Description: 查看一下 park
 */
@Slf4j(topic = "c.Test1")
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            log.debug("resume");
        },"t1");
        t1.start();
        /*
            不注释掉 Thread.sleep
            16:27:52.928 [t1] c.Test1 -start
            16:27:54.926 [main] c.Test1 -unpark
            16:27:54.926 [t1] c.Test1 -resume
         */
         Thread.sleep(2000);
        // 当注释时，会先执行unpark, 换句话说，unpark可能在park先执行
        /*
            16:24:31.759 [main] c.Test1 -unpark
            16:24:31.759 [t1] c.Test1 -start
            16:24:32.762 [t1] c.Test1 -resum
         */
        log.debug("unpark");
        LockSupport.unpark(t1);
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
