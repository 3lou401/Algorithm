package com.java.baseVal;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/24
 * Time: 17:04
 * Description: 测试1/10 是否等于 0.1
 */
public class Test1 {
    public static void main(String[] args) {
        int a = 1 , b = 10;
        System.out.println(a/ b == 0.1); // 打印结果是false
        System.out.println(a/b); //输出时0
        float c = a/b;
        System.out.println(c);//输出0.0
        // 为了保证  除法可以保留小数 ， 采用 DecimalFormat
        DecimalFormat df = new DecimalFormat("0.00");
        float d = a / b;
        System.out.println(df.format(d)); // 输出 0.00
        System.out.println(df.format(a/b)); //输出 0.00
        System.out.println(df.format((float)a/b)); //输出 0.10

    }
}
