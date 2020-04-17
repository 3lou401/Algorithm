package com.concurrent.reentrantlockshow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/14
 * Time: 16:16
 * Description:
 *      ReentrantLock 可以是超时退出的
 *
 *          tryLock() 加锁失败立刻退出
 *
 */
@Slf4j(topic = "c.Test4")
public class Test4 {
    private  final  static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            log.debug("启动。。。");
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)){
                    log.debug("获取不到锁。。。");
                    return;
                }
            } catch (InterruptedException e) {
                log.debug("获取不到锁");
                return;
            }
            try {
                log.debug("成功获得锁...");
            }finally {
                lock.unlock();
            }
        },"t1");

        lock.lock();
        t1.start();
        Thread.sleep(1000);
        try {
            log.debug("释放锁");
        }finally {
            lock.unlock();
        }

    }
}
