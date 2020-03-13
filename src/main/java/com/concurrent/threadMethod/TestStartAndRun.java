package com.concurrent.threadMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/24 21:43
 * @Desc:  run()是线程任务中的一个方法，直接调用是不会开启线程的
 *          start()调用，会将线程置为就绪状态，获得cpu之后就会开启多线程
 *      测试： 通过日志查看是哪个线程执行的run
 */
@Slf4j(topic = "c.TestStartAndRun")
public class TestStartAndRun {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.debug("running");
            }
        });
        t1.setName("t1");
        t1.run();
        System.out.println("查看调用start结果");
        t1.start();
        t1.start();
    }
}
