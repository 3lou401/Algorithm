package com.JDK8.defaultMethod;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 12:02
 * Description: No Description
 */
public interface MyInterface1 {
    default void myMethod(){
        System.out.println("MyInterface1");
    }
}
