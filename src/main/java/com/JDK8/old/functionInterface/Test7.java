package com.JDK8.old.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/29 11:18
 * @Desc:  predicator测试
 */
public class Test7 {
    public static void main(String[] args) {
        Test7 test7 = new Test7();

        List<Integer> datas = Arrays.asList(4,14,24,3,7,99,2);
        test7.print(datas,val ->val > 20);

        test7.print(datas,val -> val %2 == 0);
        test7.print(datas,val-> true);

    }

    public void print(List<Integer> list, Predicate<Integer> predicate){
        for(Integer item : list){
            if (predicate.test(item)){
                System.out.printf(" - "+item);
            }
        }
        System.out.println();
    }
    public void print1(List<Integer> list){
        for(Integer item : list){
            if (item % 2 == 0){
                System.out.printf(" - "+item);
            }
        }
        System.out.println();
    }


}
