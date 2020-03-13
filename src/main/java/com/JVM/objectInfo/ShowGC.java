package com.JVM.objectInfo;

import java.util.Scanner;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/22 18:58
 * @Desc: 看一下当前使用的垃圾回收器
 *      参数 ： -verbose:gc -XX:+PrintGCDetails
 *      通过分配对象之后，前后区域内存占比，确定对象是分配到哪个区域
 *
 */
public class ShowGC {
    public static void main(String[] args) {
        byte [] a = new byte[40 * 1024 * 1024];
        System.out.println("---");
    }
}

class TestJstat{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
}