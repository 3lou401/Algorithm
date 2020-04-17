package com.JVM.outOfMemoryShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 22:18
 * Description: 测试堆内存溢出
 *  Vm args : -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class Test1 {
    public static void main(String[] args) {
        List<Test1> list = new ArrayList<>();
        while (true){
            list.add(new Test1());
        }
    }
}

