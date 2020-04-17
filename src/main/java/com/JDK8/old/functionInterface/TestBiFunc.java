package com.JDK8.old.functionInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/26 22:56
 * @Desc:
 */
public class TestBiFunc {
    public int calc(int a, int b, BiFunction<Integer,Integer,Integer> function){
        return function.apply(a,b);
    }

    public  int calAndThen(int a, int b, BiFunction<Integer ,Integer,Integer> bf,
                           Function<Integer,Integer> function){
        return bf.andThen(function).apply(a,b);
    }

    public static void main(String[] args) {
        TestBiFunc tbf = new TestBiFunc();
        System.out.println("res = "+tbf.calc(3,5,(a,b)->a+b));
        System.out.println("AndThenRes = "+tbf.calAndThen(3,5,(a,b)->a+b, a->a*a));


    }

}
