package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/29
 * Time: 12:59
 * Description: Java中循环测试
 */
public class Test4 {
    public static void main(String[] args) {
        int i = 1;
        for (;i<=10;i++){
            //...
        }
        System.out.println(i); // 输出时11 ，分析， i=10时，依然满足条件，会继续执行i++

        //等价于
        int j = 1;
        while (j<=10){
            //...
            j++;
        }
    }
}
