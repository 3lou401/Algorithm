package com.JDK8.methodReference;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/12
 * Time: 12:21
 * Description: No Description
 */
public class Demo1 {
    public static void main(String[] args) {
        //简单的遍历list,不使用方法引用
        List<String> list = Arrays.asList("hello","test","test3");
        list.forEach(item-> System.out.println(item));

        //引入方法引用
        list.forEach(System.out :: println);
    }
}
