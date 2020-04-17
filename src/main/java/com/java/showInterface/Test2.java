package com.java.showInterface;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/15
 * Time: 9:41
 * Description: 测试 静态属性是否可以拥有 jdk1.8
 *
 * class文件 ：
 * Compiled from "Test2.java"
 * public interface com.java.showInterface.Test2 {
 *   public static final int a;
 *   public static void print();
 * }
 * // 说明 ： 可以有静态方法（对比之前），但还是不存在静态变量，定义的变量会自动设置为常量
 */
public interface Test2 {

    public static int a = 0;

    static void print(){
        System.out.println("--");
   }
}
