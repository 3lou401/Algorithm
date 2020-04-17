package com.JDK8.showlambda;

import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/5
 * Time: 13:27
 * Description: 看一下lambda表达式是什么
 */
public class Test2 {
    public static void main(String[] args) {
        //使用匿名内部类
        MyInterface myInterface = new MyInterface() {
            @Override
            public void print(int a, int b) {
                System.out.println(a+b);
            }
        };
        myInterface.print(3,4);


        //可以直接赋值给一个接口
        MyInterface myInterface2 = (a,b)->{
            System.out.println(a+b);
        };
        myInterface2.print(3,4);

        //lambda表达式类型
        System.out.println("正常接口实现的类型 "+myInterface.getClass());
        System.out.println("lambda的类型 "+myInterface2.getClass());
    }

    //函数式编程，传入一个行为，
    public static void method(MyInterface myInterface,int a, int b){
        myInterface.print(a,b);
    }
}
