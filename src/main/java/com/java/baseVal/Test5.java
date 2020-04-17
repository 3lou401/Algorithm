package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/29
 * Time: 13:05
 * Description: Java中switch
 */
public class Test5 {
    public static void main(String[] args) {
        int level = 5;
        switch (level){
            case 1:
                System.out.println("第一级别");
                break;
            case 2:
                System.out.println("第二级别");
                break;
            case 3:
                System.out.println("第三级别");
                break;
            default:
                System.out.println("最高级别");
        }
    }
}
