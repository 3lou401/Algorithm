package com.concurrent.jmm;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/16
 * Time: 21:45
 * Description: 可见性引入，无法退出的循环
 *   运行结果
 *          代码无法结束
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    static boolean flag = false;
    public static void main(String[] args) {
        new Thread(()->{
            while (!flag){

            }
        }).start();

        log.debug("主线程开始");
        flag = true;
    }
}
