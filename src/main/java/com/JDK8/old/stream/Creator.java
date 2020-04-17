package com.JDK8.old.stream;

import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/14
 * Time: 11:49
 * Description: No Description
 */
public class Creator {
    public static void main(String[] args) {
//        Stream<String> stringStream = Stream.of("a","b","v");
//
//        String[] strings =new String[] {"a","b","v"};
//        Stream<String> stringStream1 = Stream.of(strings);
//
//        Stream<String> stringStream2 = Arrays.stream(strings);
//
//        List<String> list = Arrays.asList(strings);
//        Stream<String> stringStream3 = list.stream();


        IntStream intStream = IntStream.of(1,4,34,12,678);
        intStream.forEach(System.out::println);
        System.out.println("----");
        //传参可以用range ,创建从 [3,8)的stream
        IntStream.range(3,8).forEach(System.out::println);
        System.out.println("---");
        //可以用rangeClosed ,创建从[3,8]的stream
        IntStream.rangeClosed(3,8).forEach(System.out::println);

    }
}
