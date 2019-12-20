package com.sort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/11 14:12
 * @desc : 不考虑通用情况，用Integer数组
 * https://blog.csdn.net/qq_36189382/article/details/78167286
 */
public class QuickSort {

    public void quickSort(int[] a,int left,int right){
        if(left > right)
            return;
        int pIndex = patition(a,left,right);
        quickSort(a,left,pIndex-1);
        quickSort(a,pIndex+1,right);
    }

    public  void sort(int [] a){
        quickSort(a,0,a.length-1);
    }


    private int patition(int[] a,int left,int right){
        int pivot = a[left];
        int pIndex = left;
        while (left < right){
            while (a[right] >= pivot && left < right)
                right--;
            while (a[left] <= pivot && left < right){
                left++;
            }
            if (left < right){
                swap(a,left,right);
            }
        }
        swap(a,pIndex,left);
        return left;

    }

    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int [] a = {45,12,88,9,5,678,321,17,19,10,52};
        System.out.printf("old array -> "+Arrays.toString(a));
        new QuickSort().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }
}
