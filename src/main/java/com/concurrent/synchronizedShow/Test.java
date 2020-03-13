package com.concurrent.synchronizedShow;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/12
 * Time: 11:25
 * Description: 测试synchronized 对于for循环
 */
@Slf4j(topic = "c.Test")
public class Test {
    static int m = 0;
    static Object obj = "";

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            showRes();
        }
    }

    public static void showRes() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 1000; i++) {
                    m++;
                }
            }
//            for (int i = 0; i < 1000;i++ ){
//                synchronized (obj){
//                    m++;
//                }
//            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 1000; i++) {
                    m--;
                }
            }
        }, "t2");
        t1.start();
        t2.start();
        //等待t1 t2执行完成
        t1.join();
        t2.join();
        log.debug("m最终是 {}", m);
    }

}
