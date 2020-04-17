package com.JDK8.Stream.baseinfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 8:13
 * Description: stream 函数式编程几个例子
 */
public class Test4 {
    public static void main(String[] args) {
        //1. 将字符串数组 转为大写，输出
        List<String> list = Arrays.asList("hello","hi","good");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        //2. 将数组中每个值求平方，然后求和，输出
        int [] a = {1,3,4,5};
        int sum = Arrays.stream(a).map(i->i*i).sum();
        System.out.println(sum);

        //3、将几个数组合成一个数组，然后求平方，再求和
        int[][] b ={ {1},{2,3},{5}};
        Arrays.stream(b).flatMapToInt(arr->Arrays.stream(arr)).map(item->item * item)
                .forEach(System.out::println);
    }
}
