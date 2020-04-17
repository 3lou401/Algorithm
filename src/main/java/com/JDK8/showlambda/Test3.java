package com.JDK8.showlambda;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/5
 * Time: 14:06
 * Description: lambda表达式可以提供 “函数式编程的效果”
 */
public class Test3 {
    public static void main(String[] args) {
        //传统编程中，想要修改print的逻辑，只能定义一个新的匿名内部类

        //比如不想打印两者之和，改为打印之差
        method(new MyInterface() {
            @Override
            public void print(int a, int b) {
                System.out.println(a - b);
            }
        }, 5, 6);

        //改为打印两者之积
        method(new MyInterface() {
            @Override
            public void print(int a, int b) {
                System.out.println(a * b);
            }
        }, 4, 5);

        //使用lambda代替
        method((a, b) -> System.out.println(a - b), 3, 4);
        method((a, b) -> System.out.println(a * b), 5, 6);
    }

    public static void method(MyInterface myInterface, int a, int b) {
        myInterface.print(a, b);
    }

}

