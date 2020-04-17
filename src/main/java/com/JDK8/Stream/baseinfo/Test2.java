package com.JDK8.Stream.baseinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/10
 * Time: 21:45
 * Description: 流的简单使用
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,6,9,4);

        //比如将上边数组 * 2 并求和
        int sum = list.stream().map(i -> i * 2).reduce(0,Integer::sum);
        System.out.println(sum);
    }
}
