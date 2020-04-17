package com.concurrent.reentrantlockshow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/14
 * Time: 11:24
 * Description: 测试锁，是否可重入
 * 可重入锁 ： 首次获得该对象锁，再次进入可直接进入
 * <p>
 * 测试代码 ： 单个线程获得reentrantlock锁，再次获得，看是否被阻塞
 *
 * 11:28:38.040 [main] c.Test2 -start
 * 11:28:38.043 [main] c.Test2 -enter m1
 * 11:28:38.044 [main] c.Test2 -enter m2
 */
@Slf4j(topic = "c.Test2")
public class Test2 {
    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            log.debug("start");
            m1();
        } finally {
            lock.unlock();
        }

    }

    private static void m1() {
        lock.lock();
        try {
            log.debug("enter m1");
            m2();
        } finally {
            lock.unlock();
        }
    }

    private static void m2() {
        lock.lock();
        try {
            log.debug("enter m2");
        } finally {
            lock.unlock();
        }
    }
}
