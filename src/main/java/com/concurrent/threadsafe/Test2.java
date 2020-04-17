package com.concurrent.threadsafe;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/17
 * Time: 9:12
 * Description: 引入线程安全分析
 */
public class Test2 {
    static int a = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                a++;
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                a--;
            }
        }, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("结果是"+a); //输出结果不固定

    }
}
