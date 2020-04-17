package com.concurrent.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/13
 * Time: 17:31
 * Description: 测试死锁
 */
@Slf4j(topic = "c.TestDeadLock")
public class TestDeadLock {
    static Object lockA = new Object();
    static Object lockB = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lockA){
                log.debug("操作A");
                synchronized (lockB){
                    log.debug("操作B");
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            synchronized (lockB){
                log.debug("操作B");
                synchronized (lockA){
                    log.debug("操作A");
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
