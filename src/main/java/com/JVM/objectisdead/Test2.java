package com.JVM.objectisdead;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/21
 * Time: 11:56
 * Description: 测试 对象一般分配到新生代的 Eden
 *  vm args : -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        byte[] a ,b,c,d;
        a=new byte[2*1024*1024];
//        b=new byte[2*1024*1024];
//        c=new byte[2*1024*1024];
//        d=new byte[2*1024*1024];
        while (true)
            Thread.sleep(50000);
    }
}
