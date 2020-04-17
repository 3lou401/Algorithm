package com.JVM.classloading.loadTime;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/22
 * Time: 18:34
 * Description: No Description
 */
public class LoadSequence {
    static class Parent{
        public static int A = 1;
        static {
            A =2 ;
        }
    }
    static class Son extends Parent{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
    }
}
