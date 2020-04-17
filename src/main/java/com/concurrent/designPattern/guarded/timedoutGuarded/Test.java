package com.concurrent.designPattern.guarded.timedoutGuarded;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/27
 * Time: 17:39
 * Description: 测试超时等待
 */
@Slf4j(topic = "c.Test")
public class Test {

    static class TimedGuarded {
        private Object response;

        public synchronized Object get(long time) {
            long start = System.currentTimeMillis();
            long passed = 0; // 已经花费的时间
            while (response == null) {
                if (passed >= time){
                    break;
                }
                long neededWait = time - passed;
                try {
                    this.wait(neededWait); // 防止虚假唤醒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passed = System.currentTimeMillis() - start;
            }
            return response;
        }

        public synchronized void complete(Object object){
            response = object;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        TimedGuarded timedGuarded = new TimedGuarded();
        new Thread(() -> {
            Object res = timedGuarded.get(2000);
            log.debug(res.toString());
        }).start();
        new Thread(() -> {
            timedGuarded.complete("name");
        }).start();
    }
}
