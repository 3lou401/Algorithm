package com.java.String;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/27
 * Time: 11:51
 * Description: Java中字符串
 *      不可变对象，认为共享带来的高效，远大于拼接字符串带来的负面影响
 *
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = s1.substring(0,5)+"W"+s1.substring(6);
        System.out.println(s2); //helloWorld
    }
}
