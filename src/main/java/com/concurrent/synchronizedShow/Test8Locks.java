package com.concurrent.synchronizedShow;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/4 21:03
 * @Desc:  测试synchronized 锁住不同对象的表现
 */
public class Test8Locks {
}
//第一种情形 ： 只锁住成员方法
/*@Slf4j(topic = "c.TestLock1")
class TestLock1{
    public static void main(String[] args) {
        Num1 num1 = new Num1();
        new Thread(()->{
            log.debug("begin");
            num1.a();
        },"t1").start();
        new Thread(()->{
            log.debug("begin");
            num1.b();
        },"t2").start();
    }
}
@Slf4j(topic = "c.Num1")
class Num1{
    public synchronized void a(){
        log.debug("1");
    }
    public synchronized void b(){
        log.debug("2");
    }
}*/

//情形2 ： synchronozed +成员方法 +
/*@Slf4j(topic = "c.TestLock1")
class TestLock{
    public static void main(String[] args) {
        Num1 num1 = new Num1();
        new Thread(()->{
            log.debug("begin");
            try {
                num1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            log.debug("begin");
            num1.b();
        },"t2").start();
    }
}
@Slf4j(topic = "c.Num1")
class Num1{
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        log.debug("1");
    }
    public synchronized void b(){
        log.debug("2");
    }
}*/

/*@Slf4j(topic = "c.TestLock1")
class TestLock{
    public static void main(String[] args) {
        Num1 num1 = new Num1();
        new Thread(()->{
            log.debug("begin");
            try {
                num1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            log.debug("begin");
            num1.b();
        },"t2").start();
        new Thread(()->{
            log.debug("begin");
            num1.c();
        },"t3").start();
    }
}
@Slf4j(topic = "c.Num1")
class Num1{
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        log.debug("1");
    }
    public synchronized void b(){
        log.debug("2");
    }
    public  void c(){
        log.debug("3");
    }
}*/

// 锁住的不是同一个对象
/*
@Slf4j(topic = "c.TestLock1")
class TestLock{
    public static void main(String[] args) {
        Num1 num1 = new Num1();
        Num1 num2 = new Num1();
        new Thread(()->{
            log.debug("begin");
            try {
                num1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            log.debug("begin");
            num2.b();
        },"t2").start();
    }
}
@Slf4j(topic = "c.Num1")
class Num1{
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        log.debug("1");
    }
    public synchronized void b(){
        log.debug("2");
    }
}*/

//一个锁住的是静态方法，一个锁住的是成员方法
//@Slf4j(topic = "c.TestLock1")
//class TestLock{
//    public static void main(String[] args) {
//        Num1 num1 = new Num1();
//        new Thread(()->{
//            log.debug("begin");
//            try {
//                Num1.a();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"t1").start();
//        new Thread(()->{
//            log.debug("begin");
//            num1.b();
//        },"t2").start();
//    }
//}
//@Slf4j(topic = "c.Num1")
//class Num1{
//    public synchronized static void a() throws InterruptedException {
//        Thread.sleep(1000);
//        log.debug("1");
//    }
//    public synchronized void b(){
//        log.debug("2");
//    }
//}


//都锁住静态方法
@Slf4j(topic = "c.TestLock1")
class TestLock{
    public static void main(String[] args) {
        Num1 num1 = new Num1();
        new Thread(()->{
            log.debug("begin");
            try {
                Num1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            log.debug("begin");
            num1.b();
        },"t2").start();
    }
}
@Slf4j(topic = "c.Num1")
class Num1{
    public synchronized static void a() throws InterruptedException {
        Thread.sleep(1000);
        log.debug("1");
    }
    public synchronized  void b(){
        log.debug("2");
    }
}