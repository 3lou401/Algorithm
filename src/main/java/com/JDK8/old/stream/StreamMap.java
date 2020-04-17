package com.JDK8.old.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/14
 * Time: 12:05
 * Description: No Description
 */
public class StreamMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,7,9);
        int sum = 0;
        //旧代码
        for(Integer i:list){
            i = i*2;
            sum+=i;
        }
        System.out.println(sum);

        System.out.println("----");

        //流解决
        // Integer sum = integers.reduce(0, (a, b) -> a+b);
       int sumV =  list.stream().map(iParam -> iParam * 2 ).reduce(0,Integer::sum);
        System.out.println(sumV);
    }
}
