package com.concurrent.waitNotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 10:18
 * Description: 合理的wait notify
 *         wait时 用while()判断是否满足，唤醒时用notifyAll
 */
@Slf4j(topic = "c.Condition_true")
public class Condition_True {
    final static Object room = new Object(); // 共享变量，最好设置成final
    static boolean hasCondition = false; // 是否有条件
    static boolean hasCondition2 = false; // 是否有条件

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (room) {
                log.debug("我要干活了，先看一下是否满足我的要求");
                while (!hasCondition) {
                    log.debug("条件不满足，我先wait");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasCondition) {
                    log.debug("开始干活了");
                }
            }
        }, "小南").start();
        new Thread(() -> {
            synchronized (room) {
                log.debug("我要干活了，先看一下是否满足我的要求");
                while (!hasCondition2) {
                    log.debug("条件不满足，我先wait");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasCondition2) {
                    log.debug("开始干活了");
                }
            }
        }, "小召").start();

        //主线程等待1秒，提供条件
        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (room) {
                log.debug("需要的条件来了");
                hasCondition = true;
                room.notifyAll();
            }
        }, "后勤").start();

    }
}
