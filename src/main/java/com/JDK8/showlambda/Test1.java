package com.JDK8.showlambda;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/5
 * Time: 13:33
 * Description: 测试匿名内部类 ，lambda
 */
public class Test1 {
    public static void main(String[] args) {
        //如果方法传参，需要匿名内部类
        getInnerClass(new MyInterface() {
            @Override
            public void print(int a, int b) {
                System.out.println(a+b);
            }
        },3,4);//输出7

        //使用lambda代替匿名内部类传参
        getInnerClass((aParam,bParam)->{
            System.out.println(aParam+bParam);
        },3,4); // 输出7
    }
    public static void getInnerClass(MyInterface myInterface,int a,int b){
        myInterface.print(a,b);
    }
}


