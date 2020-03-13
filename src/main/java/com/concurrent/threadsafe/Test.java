package com.concurrent.threadsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/12
 * Time: 20:41
 * Description: 测试成员变量，线程安全性问题
 */
public class Test {
    static int LOOP_NUM = 100;
    static int THREAD_NUM = 2;

    public static void main(String[] args) {
        ThreadSafeSubClass demo = new ThreadSafeSubClass();
        for (int i=0;i<THREAD_NUM;i++){
            new Thread(()->{
                demo.method1(LOOP_NUM);
            },"t"+(i+1)).start();
        }
    }
}

class ThreadUnSafe {
    List<Integer> list = new ArrayList<>();

    public void method1(int loopnum) {
        for (int i = 0; i < loopnum; i++) {
            method2();
            method3();
        }
    }
    private void method2() {
        list.add(1);
    }
    private void method3() {
        list.remove(0);
    }
}

class ThreadSafe{
    public void method1(int loopnum) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < loopnum; i++) {
            method2(list);
            method3(list);
        }
    }
    public void method2(List<Integer>list) {
        list.add(1);
    }
    public void method3(List<Integer>list) {
        list.remove(0);
    }
}
class ThreadSafeSubClass extends ThreadSafe{
    @Override
    public void method3(List<Integer> list) {
        new Thread(()->{
            list.remove(0);
        }).start();
    }
}
