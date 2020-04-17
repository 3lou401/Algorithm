package com.JDK8.Stream.baseinfo;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/10
 * Time: 22:00
 * Description: 流的原理使用举例
 */
public class Test3 {
    public static void main(String[] args) {
        //1. 比如想要打印字符串流中的元素
        Stream<String> stringStream = Stream.of("hello","world","helloWorld");
        String[] strings = stringStream.toArray(len->new String[len]);
        //len->new String[] 可以替换为
        String[] strings1 = Stream.of("hello","world","helloWorld").toArray(String[]::new);
        Arrays.asList(strings).forEach(System.out::println);

        //2  将Stream转为list
        // list的简单写法 ：stream.collect(Collectors.toList());
        List<String> list = Stream.of("hello","world","helloWorld").collect(Collectors.toList());
        list.forEach(System.out::println);
        //源码 ： Collectors.toList()
        /*
        new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
                                   (left, right) -> { left.addAll(right); return left; },
                                   CH_ID);
         */
        //更一般性调用方法
        List<String> list1 =  Stream.of("hello","world","helloWorld").collect(()->new ArrayList<String>(),
                (listParam,str)->listParam.add(str),
                (left,right)->left.addAll(right));
        list1.forEach(System.out::println);
        //使用方法引用简化写法
        List<String> list2 =  Stream.of("hello","world","helloWorld").
                collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        list2.forEach(System.out::println);

        //3 将流转为list 、set等 第三种方法 : collect(Collectors.toCollection(Supplier))
        LinkedList<String> list3 = Stream.of("hello","world","helloWorld").collect(Collectors.toCollection(LinkedList::new));
        Set<String> set =  Stream.of("hello","world","helloWorld").collect(Collectors.toCollection(HashSet::new));


    }
}
