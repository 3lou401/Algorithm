package com.JDK8.functionInterface;

import java.util.function.Function;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/26 14:13
 * @Desc: Function 接口
 */
public class Test2 {
    public static void main(String[] args) {
        Function<String,String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
    }
}
