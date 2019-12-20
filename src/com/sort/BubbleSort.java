package com.sort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/15 10:54
 * @desc：冒泡排序 相邻两者比较交换&经过多趟之后
 */
public class BubbleSort {
    public void sort(int [] a){
        int n = a.length;
        boolean flag = false; //如果每一个都比下一个值要小，则不需要在进行多趟判断,直接跳出循环
        for (int k = 0; k < n;k++){
            for (int i =0; i< n-1-k;i++){
                if (a[i] > a[i+1]){
                    swap(a,i,i+1);
                    flag= true;
                }
            }
            if (!flag ){
                break;
            }
        }
    }
    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int [] a = {45,12,88,9,5,678,321,17,19,10,52};
        System.out.printf("old array -> "+Arrays.toString(a)+"\n");
        new BubbleSort().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }
}
