package com.JVM.outOfMemoryShow;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 22:51
 * Description: No Description
 */
public class Test3 {
    public static void main(String[] args) {
        while (true){
            new Thread(()->{},"t").start();
        }
    }
}
