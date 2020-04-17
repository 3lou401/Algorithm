package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/29
 * Time: 13:11
 * Description: Java中中断流程 break 和continue
 */
public class Test6 {
    public static void main(String[] args) {
        //break语句 ： 中断循环，结束循环
        int  age = 15;
        int year = 2010;
//        while (age < 25){
//            if (year > 2015){
//                break;
//            }
//            System.out.println("当前是 "+age +" 当前年份 "+year);
//            age++;
//            year++;
//        }
//        //等价于
//        while (age < 25 && year <= 2015){
//            System.out.println("当前是 "+age +" 当前年份 "+year);
//            age++;
//            year++;
//        }
        //测试是跳出一层循环，还是多层循环 : 发现只会跳出一层循环
        for (int i = 1; i< 12; i++){
            System.out.println("这是外层循环， 第"+i);
            for (int j = 4; j > 0; j--){
                if (i > 5){
                    break;
                }
                System.out.println("内层循环，"+j);
            }
        }

    }
}
