package com.concurrent.apply.exercise;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/27 17:49
 * @Desc:  两个人烧水泡茶喝
 *     工序一共有  打冷水， 烧开水 ， 洗茶杯， 洗茶壶 ， 拿茶叶，泡茶
 *     用Thread.slepp()模拟各个工序耗时
 */
@Slf4j(topic = "c.Test")
public class Test {
    public static void main(String[] args) {
       Thread t1 = new Thread(()->{
           log.debug("打冷水。。");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           log.debug("烧开水");
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       },"老王");
       t1.start();
       Thread t2 = new Thread(()->{
           log.debug("洗水壶");
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           log.debug("洗茶杯");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           log.debug("拿茶叶");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           log.debug("等老王烧开水");
           try {
               t1.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           log.debug("泡茶");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           log.debug("结束");

       },"小王");
       t2.start();

    }
}
