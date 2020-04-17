package com.concurrent.reentrantlockshow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/14
 * Time: 11:36
 * Description: 测试可打断
 */
@Slf4j(topic = "c.Test3")
public class Test3 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("视图获得锁");
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                log.debug("没有获得锁");
                return;
            }

            try {
                log.debug("获得到锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

//        t1.start();
        /*
        11:39:46.736 [t1] c.Test3 -视图获得锁
        11:39:46.739 [t1] c.Test3 -获得到锁
         */

        //情景2 ： main先lock, t1在start, 此时，t1线程中lockInterruptibly会被阻塞
//        lock.lock();
//        t1.start();
        /*
            11:39:46.736 [t1] c.Test3 -视图获得锁
            备注：程序一直死等，没有结束
         */
        //情景3 ： main先lock, t1在start , 只不过main调用打断逻辑
        lock.lock();
        t1.start();

        Thread.sleep(1000);
        t1.interrupt();

        /*
        11:46:09.890 [t1] c.Test3 -视图获得锁
        11:46:10.888 [t1] c.Test3 -没有获得锁
        Process finished with exit code 0
         */
    }
}
