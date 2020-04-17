package com.concurrent.threadUseCase.syncinfo;

import com.concurrent.threadUseCase.syncinfo.util.FileReader;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/20 14:27
 * @Desc:
 */
@Slf4j(topic = "c.Async")
public class Async {
    public static void main(String[] args) {
        FileReader.read();
        log.error("do other thing....");
    }
}
