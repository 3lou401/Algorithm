package com.concurrent.reentrantlockshow;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/14
 * Time: 11:18
 * Description: reentrantLock的基本用法
 */
public class Test1 {
    private final static Object objLock = new Object();

    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //之前的synchronized , 使用的是对象的monitor锁
        synchronized (objLock) {
            /*
                 要编写的同步代码块
             */
        }
        // reentrantlock 等价于上边
        lock.lock();
        try {
            /*
                 要编写的同步代码块
             */
        } finally {
            lock.unlock();
        }
    }
}
