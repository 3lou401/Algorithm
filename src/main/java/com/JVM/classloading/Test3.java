package com.JVM.classloading;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/17
 * Time: 9:25
 * Description:
 *   1. 如果想要同时继承多个接口 接口中不能存在重名的变量
 *
 *   2. 按照继承等级，从上往下， 比如下边，就是 Base111 -> Base11 -> Base1
 *
 *   3. 如果继承的父类 和实现的接口都有这个变量， 编译期不会通过。
 */
public class Test3 {
}

interface  Base1{
    int age = 1;
}

interface Base11 extends Base1{
    int age = 11;
}
interface Base111 extends Base11{
}
//class Father {
//    static int age = 2;
//}
class Son  implements Base111{
    public static void main(String[] args) {
        Son s = new Son();
        System.out.println(s.age);
    }
}
