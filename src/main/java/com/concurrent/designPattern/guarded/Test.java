package com.concurrent.designPattern.guarded;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/2
 * Time: 11:05
 * Description: 采用内部类的结构，清晰展示保护性暂停的逻辑
 */
@Slf4j(topic = "c.Test")
public class Test {
    static class GuardedObject {
        private Object response;

        public synchronized Object get(){
            while (response == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
        public synchronized void complete(Object obj){
            response = obj;
            this.notifyAll();
        }
    }

    //测试
    public static void main(String[] args) {
      //两个线程模拟 “一个线程展示信息”，“一个线程用来下载数据”
        GuardedObject guardObject = new GuardedObject();

        new Thread(()->{
            log.debug("等待结果。。");
            List<String> res = (List<String>) guardObject.get();
            log.debug("结果是"+res.size());
            res.stream().forEach(s -> log.debug(s));
        },"t1").start();

        new Thread(()->{
            log.debug("准备下载。。");
            try {
                List<String> res = DownLoader.download();
                guardObject.complete(res);
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
