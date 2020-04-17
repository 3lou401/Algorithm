package com.JDK8.old.defaultMethod;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 12:03
 * Description: No Description
 */
public class MyClass implements MyInterface1,MyInterface2{
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

    @Override
    public void myMethod() {
       MyInterface2.super.myMethod();
    }
}
