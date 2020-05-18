package com.concurrent.threadpool.myThreadpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/27
 * Time: 18:17
 * Description:  线程池用的消息的队列
 */
public class BlockingQueue<T> {
    //1. 持有一个队列
    public Deque<T> queue = new ArrayDeque<T>();

    // 2、使用reentrantlock
    private ReentrantLock lock = new ReentrantLock();

    //3、队列空的条件变量
    Condition emptyWaitSet = lock.newCondition();
    //4、队列满的条件变量
    Condition fullWaitSet = lock.newCondition();

    //5、队列的容量
    private int capcity ;

    public BlockingQueue(int capcity) {
        this.capcity = capcity;
    }

    //带超时的获取
    public T poll(long timeout, TimeUnit unit){
        lock.lock();

        try {
            while (queue.isEmpty()){
                try {
                    emptyWaitSet.awaitNanos(unit.toNanos(timeout));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signalAll();
            return t;
        }finally {
            lock.unlock();
        }
    }

    //取线程
    public T poll(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signalAll();
            return t;
        }finally {
            lock.unlock();
        }
    }

    //添加
    public void put(T t){
        lock.lock();
        try {
            while (queue.size() == capcity){
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(t);
            emptyWaitSet.signalAll(); // 唤醒因为空等待的
        }finally {
            lock.unlock();
        }
    }

}
