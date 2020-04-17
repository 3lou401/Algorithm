package com.JDK8.Stream.baseinfo;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 10:47
 * Description:  验证“流只可以被操作一次”，“中间操作都是返回新的流”，“中间操作是延迟的”
 */
public class Test7 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,3,4);
        System.out.println(stream);
        System.out.println(stream.filter(item->item > 1));
        System.out.println(stream.distinct()); //抛出异常

        //返回的都是一个新的流
//        Stream.of(1,2,3,4).filter(i->i>1).distinct().forEach(System.out::println);
        Stream<Integer> stream1 = Stream.of(1,4,3);
        Stream<Integer> stream2 = stream1.filter(i -> i>1);
        Stream<Integer> stream3 = stream2.distinct();
        System.out.println(stream1);
        System.out.println(stream2);
        System.out.println(stream3);
        //发现输出的都是新的流

        Stream<String> stringStream = Stream.of("a","b","c");
        stringStream.map(str->{
            String res = str.toUpperCase();
            System.out.println("执行中间操作");
            return res;
        }).count();

    }
}
