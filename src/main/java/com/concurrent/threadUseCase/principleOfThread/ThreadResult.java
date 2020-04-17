package com.concurrent.threadUseCase.principleOfThread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/22 21:52
 * @Desc: 多线程运行的特点，交替运行，谁先谁后，不确定
 */
@Slf4j(topic = "c.ThreadResult")
public class ThreadResult {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                log.debug("running");
            }
        },"t1").start();
        new Thread(()->{
            while (true){
                log.debug("running");
            }
        },"t2").start();
    }
}
