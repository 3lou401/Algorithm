package com.sort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/15 10:42
 * @desc : 插入排序 升序
 */
public class InsertionSort {
    public void sort(int [] a){
        if (a.length <2)
            return;
       for (int i= 1 ; i<a.length;i++){
           int temp = a[i];
           int j = i;
           //比较的时候和j-1比较，边界
           for(; j > 0 && temp < a[j-1];j--){
               a[j] = a[j-1];
           }
           a[j] = temp;
       }
    }
    public static void main(String[] args) {
        int [] a = {45,12,88,9,5,678,321,17,19,10,52};
        System.out.printf("old array -> "+Arrays.toString(a)+"\n");
        new InsertionSort().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }
}
