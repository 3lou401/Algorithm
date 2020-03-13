package com.concurrent.threadMethod;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/26 12:39
 * @Desc:
 */
@Slf4j(topic ="c.TestJoin" )
public class TestJoin {
}
//r到底是多少 ： 0 因为main线成打印先执行而t1线程的赋值语句后执行
@Slf4j(topic ="c.WhyUseJoin" )
class WhyUseJoin{
     static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        test();
    }
    public static void test() throws InterruptedException {
        log.debug("start..");
        Thread t1 = new Thread(()->{
            log.debug("开始");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            r=10;
        } ,"t1");
        t1.start();
//        Thread.sleep(1000);
        log.debug("结果是 {}",r);
        log.debug("end..");
    }
}

// join可以解决这个问题
@Slf4j(topic = "c.TestJoinResult")
class TestJoinResult{
    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        test();
    }
    public static void test() throws InterruptedException {
        log.debug("start..");
        Thread t1 = new Thread(()->{
            log.debug("开始");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
             r=10;
        },"t1");
        t1.start();
        t1.join();
        log.debug("结果是 {}",r);
        log.debug("end..");

    }
}


//输出时间间隔是 2秒左右，因为 join()方法核心思想 ： 在Tn线程内调用t1.join(),如果此时t1没有执行结束，就等待t1执行结束
@Slf4j(topic = "c.TestJoinWaitTime")
class TestJoinWaitTime{
    static int r1 = 0;
    static int r2 = 0;
    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        },"t1");
        Thread t2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2 = 20;
        },"t2");
        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        log.debug("join begin ..");
        t2.join();
        log.debug("t2 join end..");
        t1.join();
        log.debug("t1 join end..");
        long end = System.currentTimeMillis();
        log.debug("r1 :{}, r2:{},cost:{}",r1,r2,(end - start));

    }
}


// join（long n） : 线程最长等待n毫秒， 实际等待时间 = min (n, 线程实际执行时间)
//下边实际等待时间2秒， 而不是等线程运行完成的3秒
@Slf4j(topic = "c.TestJoinTime")
class TestJoinTime{
    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                r = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        long start = System.currentTimeMillis();
        log.debug("join start");
        t1.join(2000);
        long end = System.currentTimeMillis();

        log.debug("join end r:{},cost：{}",r,(end - start));
    }
}