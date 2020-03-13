package com.concurrent.threadMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/26 10:26
 * @Desc: priority  优先级高的线程在cpu忙时可能会获得更多时间片，给任务调度器提示，
 *                      任务调度器很可能不理会
 *      在任务调度器可能不理会这一点上，类似 yield ，yield是建议让出当前线程的时间片，实际效果无法保证
 *
 *
 *
 *      while（true） 写法，只是为了测试，实际开发中不会这样写
 *
 */
@Slf4j(topic = "c.TestPriority")
public class TestPriorityAndYield {
    public static void main(String[] args) {
        Runnable runnable1 = ()->{
                int count = 0;
                while (true){
                    System.out.println("----t1 "+(++count));
                }
        };
        Runnable runnable2 = ()->{
                int count = 0;
                while (true){
                    //测试yield
//                    Thread.yield();
                    System.out.println("        -------t2 "+(++count));
                }
        };
        Thread t1 = new Thread(runnable1,"t1");
        Thread t2 = new Thread(runnable2,"t2");
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        Thread t = new Thread("t"){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}
