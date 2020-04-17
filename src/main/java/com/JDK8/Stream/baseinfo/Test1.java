package com.JDK8.Stream.baseinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/10
 * Time: 18:50
 * Description: Stream 类的源码说明 流的基础创建
 */
public class Test1 {
    public static void main(String[] args) {
        //方式一 ： 直接调用Stream.of ，少见
        Stream<String> stream = Stream.of("a","c","b");
        // String [] strings = stream.toArray(lenParam->new String[lenParam]);
        //等价于，本质上一样
        String [] strings = stream.toArray(String[]::new);
        Arrays.asList(strings).forEach(System.out::println);

        // 第三种方式 list.stream
        List<String> slist = Arrays.asList("hello","hi","good");
        Stream<String> streambylist = slist.stream();


        //比如部分具体的stream  IntStream
        IntStream.of(new int[]{2,3,4,5,5,6,7,8,9}).forEach(e-> System.out.println(e));

        System.out.println("-----");
        IntStream.range(3,8).forEach(System.out::println);

    }
}
