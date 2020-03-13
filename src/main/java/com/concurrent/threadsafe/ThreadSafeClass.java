package com.concurrent.threadsafe;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 9:23
 * Description: 线程安全的类
 */
public class ThreadSafeClass {
    public static void main(String[] args) throws InterruptedException {
        test2();
    }
    private static void test2() throws InterruptedException{
        Hashtable hashtable = new Hashtable();
        for (int i=0; i<4;i++){
            new Thread(()->{
                if (hashtable.get("key") == null){
                    hashtable.put("key","aaa");
                }
            },"Thread"+(1+i)).start();
            Thread.sleep(2000);
            System.out.println(hashtable.get("key"));
        }
    }

    private static void test1() throws InterruptedException {
        Hashtable hashtable = new Hashtable();
        new Thread(()->{
            hashtable.put("name","zhangsan");
        }).start();
        new Thread(()->{
            hashtable.put("name","lisi");
        }).start();
        Thread.sleep(2000);
        System.out.println(hashtable.get("name"));
    }
}
