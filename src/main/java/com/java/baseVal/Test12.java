package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/1
 * Time: 15:10
 * Description: 测试 包装类和基本数据类型
 */
public class Test12 {
    public static void main(String[] args) {
        /** == 比较的是两个integer对象的地址， 所以 a == b输出false ；
         *  Java中为了节省，-128 - 127 的Integer包装类型是复用的，所以c == d
         *  正确的比较两个integer值相同，用Integer.equals()
         * **/
        Integer a = 1000;
        Integer b =1000;
        System.out.println(a == b); // 输出false

        Integer c = 120;
        Integer d = 120;
        System.out.println(c == d); //输出true

        System.out.println("a equals b :" + a.equals(b)); //输出 true
    }
}
