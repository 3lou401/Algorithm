package com.concurrent.waitNotify;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/19
 * Time: 20:01
 * Description: No Description
 */
@Slf4j(topic = "c.TestWait")
public class TestWait {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        new Thread(()->{
            log.debug("begin");
            synchronized (obj){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("other oper");
        },"t1").start();

        new Thread(()->{
            log.debug("begin");
            synchronized (obj){
                log.debug("do everyThing ..");
                obj.notify();
            }
        },"t2").start();

    }
}
