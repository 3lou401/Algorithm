package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/27
 * Time: 14:05
 * Description: No Description
 */
public class Test2 {
    public static void main(String[] args) {

        test();
    }
    public static void test(){
        int a = 12;
        {
            int b = a;
            {
                b = 13;
                int c = b;
            }
//            System.out.println(c);
        }
    }
}
