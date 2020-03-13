package com.concurrent.shareobject;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/2 18:53
 * @Desc: 举例 ：一个线程对一个变量做5000次加法，一个线程对该变量做5000次减法，按理说结果还是0, 但实际输出不一定
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i < 1000000; i++){
            testSyncRoom(i);
        }
    }
    public static void test(int y) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i=0;i<5000;i++){
                count++;
            }
        },"t1");
        Thread t2 =   new Thread(()->{
            for (int i=0;i<5000;i++){
                count--;
            }
        },"t2");

        t1.start();
        t2.start();
        //等待t1 t2执行完成，查看输出结果
        t1.join();
        t2.join();
        log.debug("第 "+y+" 次输出结果 ："+count);
    }
    public static void testSync(int y) throws InterruptedException {
        Object obj = new Object(); //用来作为共享对象
        Thread t1 = new Thread(()->{
            for (int i=0;i<5000;i++){
                synchronized (obj){
                    count++;
                }
            }
        },"t1");
        Thread t2 =   new Thread(()->{
            for (int i=0;i<5000;i++){
                synchronized (obj){
                    count--;
                }
            }
        },"t2");

        t1.start();
        t2.start();
        //等待t1 t2执行完成，查看输出结果
        t1.join();
        t2.join();
        log.debug("第 "+y+" 次输出结果 ："+count);
    }
    public static void testSyncRoom(int y) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(()->{
            for (int i=0;i<5000;i++){
                room.increment();
            }
        },"t1");
        Thread t2 =   new Thread(()->{
            for (int i=0;i<5000;i++){
               room.decrement();
            }
        },"t2");
        t1.start();
        t2.start();
        //等待t1 t2执行完成，查看输出结果
        t1.join();
        t2.join();
        log.debug("第 "+y+" 次输出结果 ：{}"+room.getCounter());
    }
}

class Room{
    private  int counter = 0;
    public void increment(){
        synchronized (this){
            counter++;
        }
    }
    public void decrement(){
        synchronized (this){
            counter--;
        }
    }
    public int getCounter(){
        return counter; //先测试不加锁是否可以
    }
}