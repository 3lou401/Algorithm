package com.concurrent.waitNotify;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 10:07
 * Description: 虚假唤醒
 */
@Slf4j(topic = "c.Condition_3")
public class Condition_3 {
    final static Object room = new Object(); // 共享变量，最好设置成final
    static boolean hasXiaoNanCondition = false; // 是否有条件
    static boolean hasXiaoZhaoCondition = false; // 是否有条件
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (room){
                log.debug("我要干活了，先看一下是否满足我的要求");
                if (!hasXiaoNanCondition){
                    log.debug("条件不满足，我先wait");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasXiaoNanCondition){
                    log.debug("开始干活了");
                }else{
                    log.debug("没条件，干不了啊");
                }
            }
        },"小南").start();

        new Thread(()->{
            synchronized (room){
                log.debug("我要干活了，先看一下是否满足我的要求");
                if (!hasXiaoZhaoCondition){
                    log.debug("条件不满足，我先wait");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasXiaoZhaoCondition){
                    log.debug("开始干活了");
                }else{
                    log.debug("没条件，干不了");
                }
            }
        },"小召").start();

        //主线程等待1秒，提供条件
        Thread.sleep(1000);
        new Thread(()->{
            synchronized (room){
                log.debug("需要的条件来了");
                hasXiaoZhaoCondition = true;
                room.notify();// 虚假唤醒，使用notifyAll()保证起码唤醒小召
            }
        },"后勤").start();

    }
}
