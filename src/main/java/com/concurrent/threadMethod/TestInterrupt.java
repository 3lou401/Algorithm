package com.concurrent.threadMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/26 22:03
 * @Desc: 测试 interrupt方法
 *
 */
@Slf4j(topic = "c.TestInterrupt")
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                log.debug("sleeping");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        log.debug("测试打断。。。");
        t1.interrupt();
        log.debug("t1 state : {} t1 interrupt :{}",t1.getState(),t1.isInterrupted());
    }
}
@Slf4j(topic = "c.TestInterruptRunning")
class TestInteruptRunning{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
           while (true){

           }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        log.debug("t1 state : {}, t1 interrupt :{}",t1.getState(),t1.isInterrupted());
    }
}@Slf4j(topic = "c.TestModifyInterrupt")
class TestModifyInterrupt{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (true){
                boolean interrupt = Thread.currentThread().isInterrupted();
                if (true){
                    log.debug("被打断了..");
                    break;
                }
            }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        log.debug("t1 state : {}, t1 interrupt :{}",t1.getState(),t1.isInterrupted());
    }
}