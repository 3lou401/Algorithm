package com.JDK8.functionInterface;

import java.util.function.Function;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/26 22:21
 * @Desc: Function使用举例
 */
public class Test3 {
    public  int compute(int a, Function<Integer,Integer> function){
        int res = function.apply(a);
        return res;
    }
    public String concat(int a,Function<Integer,String>func){
        return func.apply(a);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println("--测试lambda传递函数接口例子-");
        System.out.println(test3.compute(2,(x)->{return x *  x;})); // 输出为4
        System.out.println(test3.compute(5,(x)->{return x *  x;})); // 输出为25
        // 执行过程实际上，  对传入的2（5） 执行平方
        System.out.println(test3.compute(2,x->x+5)); // 输出7
        System.out.println(test3.compute(5,x->x+5)); // 输出10
        // 对于表达式而言， {return x+5;} 等价于 x+5
        System.out.println(test3.concat(13,(a)->a+" is Hero")); //13 is Hero

        // 也可以定义好函数，在传入
        Function<Integer,Integer> func = value -> value * value;
        System.out.println(test3.compute(13,func));

    }
}
