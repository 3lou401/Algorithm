package com.concurrent.threadUseCase.principleOfThread;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/22 22:06
 * @Desc:  JVM栈是线程私有的，创建一个线程会为其分配一块栈内存
 *               栈 由 多个栈帧组成（frames）, 对应每次调用方法，
 *               每个线程当前只有一个活动栈帧，对应着正在调用方法
 *               可以在IDEA中通过debug查看查看栈调用
 */
public class ThreadFrames {

    public static void main(String[] args) {
        method1(10);
    }
    public static int method1(int x){
        int y = x + 1;
        method2(y);
        return y;
    }
    public static void method2(int z){
        System.out.println(z+"");
    }
}
