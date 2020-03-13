package com.concurrent.ThreadState;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/27 17:29
 * @Desc: 线程中六种状态
 *
 */
@Slf4j(topic = "c.Test")
public class Test {
    public static void main(String[] args) {
        // New
        Thread t1 = new Thread(()->{},"t1");
        //runnable
        Thread t2 = new Thread(()->{
            while (true){}
        },"t2");
        t2.start();
        //timed_waiting
        Thread t3 = new Thread(()->{
            synchronized (Test.class){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3");
        t3.start();
        // waiting
        Thread t4  = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t4");
        t4.start();

        //blocked 等待锁
        Thread t5 = new Thread(()->{
            synchronized (Test.class){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t5");
        t5.start();

        //Terminated
        Thread t6 = new Thread(()->{
            log.debug("running");
        }
        ,"t6");
        t6.start();


        log.debug("t1 : "+ t1.getState());
        log.debug("t2 : "+ t2.getState());
        log.debug("t3 : "+ t3.getState());
        log.debug("t4 : "+ t4.getState());
        log.debug("t5 : "+ t5.getState());
        log.debug("t6 : "+ t6.getState());
    }
}
