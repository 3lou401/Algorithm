package com.concurrent.stackFrames;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/27 12:05
 * @Desc:  测试main线程结束之后，t1线程是否结束
 *         发现 java进程中，只要有一个线程没停止，进程就不会结束
 */
@Slf4j(topic = "c.Test3")
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    break;
                }
            }
        },"t1");
        t1.start();
        Thread.sleep(2000);
        log.debug("main结束..");

    }
}
