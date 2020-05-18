package com.concurrent.threadpool.myThreadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/27
 * Time: 21:22
 * Description: No Description
 */
@Slf4j(topic = "c.Test")
public class Test {
    public static void main(String[] args) {
        ThreadPool pool =
                new ThreadPool(4,1000, TimeUnit.MILLISECONDS,10);
        for (int i=0;i<5;i++){
            int j = i;
            pool.execute(()->{
                log.debug("{}",j);
            });
        }
    }
}
