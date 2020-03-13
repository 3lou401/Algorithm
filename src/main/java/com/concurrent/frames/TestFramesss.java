package com.concurrent.frames;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/24 21:06
 * @Desc:   测试多线程运行时，栈帧变化，多线程运行原理
 *          debug时采用 多线程模式
 *
 */
public class TestFramesss {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           method1(10);
        },"t1");
        t1.start();

        method1(20);
    }
    private static void method1(int x){
        int y= x+1;
        Object c = method2();
        System.out.println(c);
    }
    private static Object method2(){
        String s = "123";
        return s;
    }
}
