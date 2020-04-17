package com.JVM.classloading;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/18
 * Time: 11:21
 * Description: No Description
 */
public class Demo4 {
    static int i = 10;
    static {
        i = 5;
        System.out.println(i);
    }
}
