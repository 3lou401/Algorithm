package com.JDK8.old.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/24
 * Time: 14:15
 * Description: 什么时候使用flatmap ,什么时候使用map
 * 输出
 * 你好 zhangsan
 * 你好 lisi
 * 你好 wangwu
 * Hi zhangsan
 * Hi lisi
 * Hi wangwu
 * Hello zhangsan
 * Hello lisi
 * Hello wangwu
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> hilist = Arrays.asList("你好","Hi","Hello");
        List<String> people = Arrays.asList("zhangsan","lisi","wangwu");
        //1 * 2 比如 你好 zhangsan ； 你好 lisi ; 你好 wangwu
        List<String> list =
                hilist.stream().flatMap(item->people.stream().map(item2 -> item+" "+item2)).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
