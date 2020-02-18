package com.JVM.outOfMemoryShow;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/14 0:00
 * @Desc: 主要目的，简单看一下内存溢出 & JVM运行时输出堆信息 & 使用工具分析溢出信息
 */
public class TestOutOfMemory {
    public static void main(String[] args) throws Exception{
        System.out.printf("下边先模拟一下，代码错误导致内存溢出...打开电脑内存监控工具...\n");
        List<DemoBean> demoBeans = new ArrayList<>();
        int i = 1;
        while (i++<10000000){
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");
            System.out.printf("添加一个对象\n");

        }
        // 阶段1 ： 实际上，测试过程中发现哪怕内存到了一定阶段，还是可以源源不断添加新对象
        //猜测原因有两个 ：一 电脑性能太过于强悍，一时半会测不出抛异常， 二 添加的重复对象，存在不知道的优化

        //阶段二 ： 通过jvm参数调小堆大小
    }
}
class DemoBean{
    private String name;

    public DemoBean(String name) {
        this.name = name;
    }
}