package com.JDK8.old.defaultMethod;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 12:02
 * Description: No Description
 */
public interface MyInterface2 {
    default void myMethod(){
        System.out.println("myInterface2");
    }
}
