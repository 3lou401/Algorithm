package com.JDK8.Stream.baseinfo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 9:56
 * Description: 一个集合找出大于2的元素，每个元素* 2，忽略前两个再选择前两个 求和
 *
 */
public class Test6 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7,2,9,4);
        /*
        找出大于2的 filter() ;  每个元素* 2 mapToInt() ; 忽略前两个 skip(2) ; 再选择前两个limit(2); 求和 sum
         */
        int sum = list.stream().filter(item->item>2).mapToInt(item->item*2).skip(2).limit(2).sum();
        System.out.println(sum);
        IntSummaryStatistics intSummaryStatistics =
                list.stream().filter(item->item>2).mapToInt(item->item*2).skip(2).limit(2).summaryStatistics();
       int max =  intSummaryStatistics.getMax();
        System.out.println(max);
        int min = intSummaryStatistics.getMin();
        System.out.println(min);
    }
}
