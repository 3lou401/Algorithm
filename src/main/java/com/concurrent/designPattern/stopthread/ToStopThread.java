package com.concurrent.designPattern.stopthread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/27 11:24
 * @Desc: t1优雅的终止t2线程
 */
@Slf4j(topic = "c.ToStopThread")
public class ToStopThread {
    public static void main(String[] args) throws InterruptedException {
        MonitorThread monitorThread = new MonitorThread();

        monitorThread.start();
        Thread.sleep(5000);
        monitorThread.stop();
    }
}
@Slf4j(topic = "c.MonitorThread")
class MonitorThread{
    Thread t2;
    public void start(){
        t2 = new Thread(()->{
            while (true){
                boolean isInterrupt = Thread.currentThread().isInterrupted();
                if (isInterrupt){
                    log.debug("被打断了，我要处理后事。。");
                    break;
                }else {
                    log.debug("执行监控记录");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        t2.start();
    }
    public void stop(){
        t2.interrupt();
    }
}
