package com.concurrent.waitNotify;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 9:25
 * Description: 用几个例子，递进描述如何优化多线程代码
 *      只用sleep解决
 */
@Slf4j(topic = "c.Condition_1")
public class Condition_1 {

    final static Object room = new Object(); // 共享变量，最好设置成final
    static boolean hasCondition = false; // 是否有条件
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (room){
                log.debug("我要干活了，先看一下是否满足我的要求");
                if (!hasCondition){
                    log.debug("条件不满足，我不干");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (hasCondition){
                    log.debug("开始干活了");
                }
            }
        },"小南").start();
        //5个干活线程
        for (int i =0 ;i < 5;i++){
            new Thread(()->{
                synchronized (room){
                    log.debug("开始干活了");
                }
            },"干活的").start();
        }
        //主线程等待1秒，提供条件
        Thread.sleep(1000);
        new Thread(()->{
            log.debug("需要的条件来了");
            hasCondition = true;
        },"后勤").start();

    }
}
