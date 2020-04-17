package com.JDK8.old.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 11:46
 * Description: 类名：：new 构造方法引用
 */
public class Demo4 {
    public static void main(String[] args) {
        String s1 = getString1(()->new String());
        System.out.println(s1);
        System.out.println("----");
        String s2 = getString1(String::new);
        System.out.println(s2);
        System.out.println("----");
        String s3 = getString2("nihao",(param)->new String(param));
        System.out.println(s3);
        String s4 = getString2("nihao",String::new);


    }
    private static String getString1(Supplier<String> supplier){
        return supplier.get()+"aa";
    }
    private static String getString2(String param, Function<String,String> function){
        return function.apply(param);
    }
}
