package com.java.showReflect;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/2
 * Time: 10:00
 * Description: 测试获取 "Class类对象"
 */
public class Test1 {

    static class Show {

    }

    public static void main(String[] args) {
        Show show = new Show();
        System.out.println("查看根据对象获取 Class类对象");
        Class showC = show.getClass() ; // 利用Object的getClass()方法
        System.out.println(showC.getName()); //com.java.showReflect.Test1$Show
    }
}
