package com.sort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/18 10:39
 * @desc : 希尔排序
 */
public class ShellSort {
    public void sort(int[] a){
        int n = a.length;
        int heap =1;
        while (heap < n/3) {
            heap = heap * 3 + 1;
        }
        while (heap >= 1 ){
            for (int i = heap ; i < n ;i++){
                int temp =a[i];
                int j = i;
                // 注意 比较的是 temp和每一个数据比较而不是 a[j]
                for (; j >= heap && temp < a[j-heap] ;j-=heap){
                    a[j] = a[j-heap];
                }
                a[j] = temp;
            }
            heap /= 3;
        }
    }

    // 希尔排序 比较相邻h的数是，可以用直接交换 也可以用 往后移位的方式
    public static void main(String[] args) {
        int [] a = {45,12,88,9,5,678,321,17,19,10,52};
        System.out.printf("old array -> "+Arrays.toString(a)+"\n");
        new ShellSort().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }

}
