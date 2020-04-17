package com.JDK8.Stream.baseinfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/10
 * Time: 21:35
 * Description: collect
 */
public class Test9 {
    public static void main(String[] args) {
        //Stream to list
//        Stream<String> stream = Stream.of("a","c","b");
//        List<String> stringList =stream.collect(Collectors.toList());
//        stringList.forEach(System.out::println);
        //另一种写法
//        Stream<String> stringStream = Stream.of("a","c","b");
//        List<String> stringList = stringStream.collect(()->new ArrayList(),
//                ((arrayList, s) -> arrayList.add(s)),
//                ((arrayList, arrayList2) -> arrayList.addAll(arrayList2)));
//        stringList.forEach(System.out::println);
        //替换为方法引用
        Stream<String> stringStream = Stream.of("a", "c", "b");
        List<String> list = stringStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        list.forEach(System.out::println);
        //理解stream的collect方法 ， collect翻译：收集
        List<String> list1 = stringStream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        String str = stringStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
