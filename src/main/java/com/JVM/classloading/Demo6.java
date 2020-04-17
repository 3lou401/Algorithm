package com.JVM.classloading;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/18
 * Time: 12:14
 * Description: No Description
 */
public class Demo6 {
    static {
        try {
            //模拟执行时间过长
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
