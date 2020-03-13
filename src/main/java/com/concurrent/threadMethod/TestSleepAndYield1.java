package com.concurrent.threadMethod;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/24 22:00
 * @Desc: 对比sleep和yield方法
 */
@Slf4j(topic = "c.TestSleepAndYield1")
public class TestSleepAndYield1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        log.debug("t1 temp state : {}", t1.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 temp state : {}", t1.getState());

    }
}

//interupt可以打断正在sleep的线程
@Slf4j(topic = "c.SleepAndInterrupt")
class TestSleepAndInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                log.debug("Running..");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("interrupted..");
                    e.printStackTrace();
                }
            }
        };

        t2.start();
        Thread.sleep(1000);
        log.debug("t2 state {}", t2.getState());
        t2.interrupt();
    }
}


// 建议使用TimeUnit的方法代替Time.sleep()
@Slf4j(topic = "c.TestTimeUnit")
class TestTimeUnit{
    public static void main(String[] args) {
        log.debug("start..");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("end..");
    }
}