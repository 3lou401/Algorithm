package com.concurrent.threadUseCase.methodToConcurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/22 15:05
 * @Desc: 实现线程的方式
 */
public class HowTo {
}
//方式一 ： extends Thread , 本质上是将任务和线程结合在一起
@Slf4j(topic = "c.MyThread")
class MyThread extends  Thread{
    @Override
    public void run() {
        log.error("这是我的线程");
    }

    public static void main(String[] args) {
        log.error("main主线程打印");
        MyThread thread = new MyThread();
        thread.setName("t0");
        thread.start();
    }
}

//方式二 ： implements Runnable接口 + Thread +start， 将任务和线程分开
// 本质上，线程 start 会走 Thread的run方法，
// 当传入Runnable对象时，Thread对象选择走Runnable的run()方法
//使用方式一的时候，走重写的run方法
@Slf4j(topic = "c.MyRunnable")
class MyRunnable implements Runnable{
    @Override
    public void run() {
        log.error("这是我的线程");
    }

    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();
        Thread temp = new Thread(myRunnable);
        temp.setName("t1");
        temp.start();
        log.error("main主线程打印");

    }
}

// 方式三 : 使用FutureTask
//slf4j {}起到占位符功能
@Slf4j(topic = "c.TestFutureTask")
class TestFutureTask{
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running");
                Thread.sleep(2000);
                return 12;
            }
        });
        Thread thread = new Thread(futureTask,"t3");
        thread.start();
        try {
            log.debug("{}",futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}