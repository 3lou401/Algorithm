package com.concurrent.designPattern.runseqenctial;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/16
 * Time: 15:22
 * Description: 程序的顺序控制
 */
@Slf4j(topic = "c.Test1")
public class Test1 {

    static  Object lock = new Object();

    static boolean t2returned = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lock){
                while (!t2returned){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        },"t1");
        Thread t2 = new Thread(()->{
            synchronized (lock){
                t2returned = true;
                log.debug("2");
                lock.notifyAll();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
@Slf4j(topic = "c.Demo2")
class Demo2{
    static ReentrantLock lock = new ReentrantLock();
    static Condition t2ReturnWaitSet = lock.newCondition();
    static boolean t2Returned = false;
    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            try {
                while (!t2Returned){
                    t2ReturnWaitSet.await();
                }
                log.debug("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            lock.lock();
            try {
                log.debug("2");
                t2Returned = true;
                t2ReturnWaitSet.signalAll();
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}

@Slf4j(topic = "c.Demo3")
class Demo3{
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            LockSupport.park();
            log.debug("1");
        },"t1");
        Thread t2 = new Thread(()->{
            log.debug("2");
            LockSupport.unpark(t1);
        },"t2");
        t1.start();
        t2.start();
    }
}
