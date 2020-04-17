package com.JVM.classloading.loadTime;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/22
 * Time: 0:01
 * Description: No Description
 */
public class SuperClass {
    static {
        System.out.println("SuperClass Init");
    }
    static int value = 2;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass Init");
    }
}
class Test {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
/**
 *SuperClass Init
 * 2
 */