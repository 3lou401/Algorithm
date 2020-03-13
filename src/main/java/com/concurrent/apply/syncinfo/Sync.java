package com.concurrent.apply.syncinfo;

import com.concurrent.apply.syncinfo.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/20 14:31
 * @Desc: 同步调用
 */
@Slf4j(topic = "c.Sync")
public class Sync {
    public static void main(String[] args) {
        new Thread(()->{
            FileReader.read();
        }).start();
        log.error("do other thing...");
    }
}
