package com.JDK8.lambda;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/22 17:53
 * @Desc: 使用Lambda的前提，接口必须是函数式接口
 *          1、如果一个接口有且只有一个抽象方法，它是函数式接口
 *          2、给一个接口添加@FunctionalInterface注解，编译期会强制要求该方法是函数式接口
 *
 */
public class FunctionalInterfaceShow {
    public static void test(MyInterface myInterface){
        System.out.println(1);
        myInterface.method1();
        System.out.println(2);
    }
    public static void main(String[] args) {
        System.out.println("---未使用lambda表达式----");
        test(new MyInterface() {
            @Override
            public void method1() {
                System.out.println("这是我的接口。。");
            }
        });
        System.out.println("--------使用lambda表达式--------");
        test(()->{
            System.out.println("这是我的接口。。");
        });
        System.out.println("-----看一下lambda表达式究竟是啥--");
        MyInterface myInterface = ()->{
            System.out.println("这是我的接口。。");
        };
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}
@FunctionalInterface
interface MyInterface {
    void method1();
    String toString();
}
class MyInterfaceSon implements MyInterface{

    @Override
    public void method1() {

    }
}

