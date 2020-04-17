package com.JDK8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/3
 * Time: 10:37
 * Description: 函数式编程思想
 */
public class Test1 {

    public static void print (List<Integer> list , Predicate<Integer> predicate){
        for (Integer key : list){
            //打印符合条件的数据
            if (predicate.test(key)){
                System.out.println("-"+key);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,6,7,9,12);
        print(list,intV -> intV % 2 == 0); //打印偶数
        System.out.println("---打印奇数--");
        print(list,integer -> integer % 2 != 0);
    }

}
