package com.JVM.classloading;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/12
 * Time: 14:23
 * Description: No Description
 */
public class Demo1 extends Parent {
    static {
        System.out.println("demo-init");
    }

    public static void main(String[] args) {

    }
}
class Parent{
    static {
        System.out.println("parent-init");
    }
}
