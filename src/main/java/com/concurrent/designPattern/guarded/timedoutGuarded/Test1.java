package com.concurrent.designPattern.guarded.timedoutGuarded;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/1
 * Time: 11:47
 * Description: 模拟有时间限制的保护性暂停
 *      就是在保护性暂停基础上， 添加睡眠时间
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    static class GuardedObject{
        private Object response;

        public synchronized Object get(long time){
            long startTime = System.currentTimeMillis();
            long passedTime = 0;
            while (response == null){
                //如果 花费的时间已经大于要等待时间，就直接跳出循环返回
                if (passedTime >= time){
                    break;
                }
                //如果 花费时间 还不够要等待的时间，并且结果依然null
                long needWait = time - passedTime; // 如果提前唤醒，实际wait时间会是想要等待时间 - 已经wait时间
                try {
                    this.wait(needWait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 passedTime  = System.currentTimeMillis() - startTime;
            }
            return response;
        }

        public synchronized void complete(Object obj){
            response = obj;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            log.debug("看看有没有信");
            String res = (String) guardedObject.get(4000);
            log.debug(res);
        },"收信的").start();
        new Thread(()->{
            log.debug("开始");
            guardedObject.complete(null); // 测试是否被虚假唤醒 注意时间
            /**
             * 12:08:04.918 [收信的] c.Test1 -看看有没有信
             * 12:08:04.918 [送信的] c.Test1 -开始
             * 12:08:08.921 [收信的] c.Test1 -null
             */
//            guardedObject.complete("信件");
            /**
             * 12:06:31.466 [收信的] c.Test1 -看看有没有信
             * 12:06:31.466 [送信的] c.Test1 -开始
             * 12:06:31.468 [收信的] c.Test1 -hello
             */
        },"送信的").start();

    }
}
