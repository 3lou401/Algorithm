package com.concurrent.reentrantlockshow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/15
 * Time: 22:24
 * Description: 条件变量
 * 22:43:34.670 [小南] c.Test6 -先看一下是否满足要求 [false]
 * 22:43:34.680 [小南] c.Test6 -条件不满足，我先wait
 * 22:43:34.681 [小召] c.Test6 -先看一下是否满足我的要求[false]
 * 22:43:34.681 [小召] c.Test6 -条件不满足，我先wait
 * 22:43:35.670 [小南后勤] c.Test6 -需要的条件来了
 * 22:43:35.670 [小召后勤] c.Test6 -需要的条件来了
 * 22:43:35.671 [小南] c.Test6 -开始干活了
 * 22:43:35.671 [小召] c.Test6 -开始干活了
 */
@Slf4j(topic = "c.Test6")
public class Test6 {
    static boolean hasXiaoNanCondition = false; // 是否有条件
    static boolean hasXiaoZhaoCondition = false; // 是否有条件

    static ReentrantLock ROOM = new ReentrantLock();
    //等待小南条件的休息室
    static Condition XiaoNanWaitSet = ROOM.newCondition();
    //等待小召条件的休息室
    static Condition XiaoZhaoWaitSet = ROOM.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            ROOM.lock();
            try {
                log.debug("先看一下是否满足要求 [{}]",hasXiaoNanCondition);
                while (!hasXiaoNanCondition) {
                    log.debug("条件不满足，我先wait");
                    try {
                        XiaoNanWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("开始干活了");
            } finally {
                ROOM.unlock();
            }
        }, "小南").start();
        new Thread(() -> {
            ROOM.lock();
            try {
                log.debug("先看一下是否满足我的要求[{}]",hasXiaoZhaoCondition);
                while (!hasXiaoZhaoCondition) {
                    log.debug("条件不满足，我先wait");
                    try {
                        XiaoZhaoWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("开始干活了");
            } finally {
                ROOM.unlock();
            }

        }, "小召").start();
        //主线程等待1秒，提供条件
        Thread.sleep(1000);
        //小南条件满足
        new Thread(() -> {
            ROOM.lock();
            try {
                log.debug("需要的条件来了");
                hasXiaoNanCondition = true;
                XiaoNanWaitSet.signal();
            } finally {
                ROOM.unlock();
            }
        }, "小南后勤").start();

        //小召条件满足
        new Thread(() -> {
            ROOM.lock();
            try {
                log.debug("需要的条件来了");
                hasXiaoZhaoCondition = true;
                XiaoZhaoWaitSet.signal();//叫醒
            } finally {
                ROOM.unlock();
            }
        }, "小召后勤").start();
    }
}
