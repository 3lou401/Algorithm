package com.JVM.jvmTools;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/25 14:25
 * @Desc:
 */
public class TestDeadThread {
    public static void main(String[] args) {
        Object obj1 = "123";
        Object obj2 = 456;
        Thread t3 = new Thread(new MyRunnable(obj1,obj2),"t3");
        t3.start();
        Thread t4 = new Thread(new MyRunnable(obj2,obj1),"t4");
        t4.start();
    }
}
@Slf4j(topic = "c.MyRunnable")
class MyRunnable implements Runnable{
    private Object obj1;
    private Object obj2;
    public MyRunnable(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void run() {
        synchronized (obj1){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){
                log.debug("obj1 -> obj2");
            }
        }
    }
}