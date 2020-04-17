package com.JVM.classloading;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/18
 * Time: 11:28
 * Description: No Description
 */
public class Demo5 {
}

class Parent5{
    static int a = 1;
    static {
        a = 2;
    }
}
class Son5 extends Parent5{
   public  static int b = a;

    public static void main(String[] args) {
        System.out.println(Son5.b);
    }
}