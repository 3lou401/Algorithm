package com.JVM.outOfMemoryShow;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 23:18
 * Description: 测试本机内存溢出
 */
public class Test6 {
    public static void main(String[] args) {
        while (true){
            Test5.generate();
        }
    }
}
