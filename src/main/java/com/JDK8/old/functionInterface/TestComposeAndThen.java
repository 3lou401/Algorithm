package com.JDK8.old.functionInterface;

import java.util.function.Function;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/26 22:43
 * @Desc:
 */
public class TestComposeAndThen {
    public int calc(int a , Function<Integer,Integer> func1, Function<Integer,Integer> func2){
        return func1.compose(func2).apply(a);
    }
    public int calAndThen(int a , Function<Integer,Integer> func1, Function<Integer,Integer> func2){
        return func1.andThen(func2).apply(a);
    }

    public static void main(String[] args) {
        TestComposeAndThen tca = new TestComposeAndThen();
        System.out.println("compose res = "+tca.calc(3,a->a*a, a->a+2)); // 25
        System.out.println("andThen res = "+tca.calAndThen(3,a->a*a, a->a+2));//11
    }
}
