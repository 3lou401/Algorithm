package com.concurrent.frames;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/24 15:59
 * @Desc: 测试单个线程（main）运行时，栈帧变化
 *   debug 查看frames , 每调用一个方法，就会创建一个栈帧（frame）
 *             栈帧中有局部变量表，记录当前栈帧中局部变量（基本类型、引用类型）
 *             栈帧中有返回地址，记录方法调用结束之后，继续执行的代码
 *       在过程中，程序计数器会记录每次执行的代码
 *
 */
public class TestFrame {
    public static void main(String[] args) {
        method1(10);
    }
    private static  Object method1(int x){
        int y = x+ 1;
        Object c = method2();
        return c;
    }
    private static Object method2(){
        String s = "123";
        return s;
    }
}
