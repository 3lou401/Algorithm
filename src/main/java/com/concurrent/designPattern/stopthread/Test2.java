package com.concurrent.designPattern.stopthread;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/20
 * Time: 16:35
 * Description: No Description
 */
public class Test2 {
}
@Slf4j(topic = "c.Monitor2")
class Monitor2 {
    private Thread monitorT;
    private  volatile  boolean stop = false;
    private   boolean starting = false;

    public void start(){
        // 判断是否已经启动
        synchronized (this){
            if (starting){
                return;
            }
            starting = true;
        }
        //定义监控线程monitor,并启动
        monitorT = new Thread(()->{
            while (!stop){
                try {
                    Thread.sleep(1000);
                    log.debug("接下来,执行监控记录");
                    report();
                } catch (InterruptedException e) {
                }
            }
            //while循环，只要线程不结束，就一直运行
            starting = false;
        },"monitor");

        monitorT.start();
    }

    private void report() {
        log.debug("具体的监控代码");
    }

    public void stop(){
        stop = true;
        monitorT.interrupt();// 目的是立刻打断
    }
}
