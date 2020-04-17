package com.concurrent.designPattern.guarded;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/1
 * Time: 11:32
 * Description: 为了加深记忆，编写的普通保护性暂停
 */
@Slf4j(topic = "c.Test2")
public class Test2 {
    //用于 两个线程之间通信的类
    static class GuardedObject{
        private Object response;

        //synchronized 代替 synchronized(this)
        public synchronized Object get() throws InterruptedException {
            while (response == null){
                this.wait();
            }
            return response;
        }

        public synchronized void complete(Object obj){
            response = obj;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        //测试
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            try {
                Thread.sleep(2000); //模拟一秒钟送到外卖
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("准备送外卖");
            guardedObject.complete("外卖到了");
            log.debug("送完外卖了");
        },"外卖员").start();
        new Thread(()->{
            try {
                log.debug("我想吃饭");
                String  res  = (String) guardedObject.get();
                log.debug("外卖到了，开始吃饭");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"顾客").start();

    }
}
