package com.sort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/14 17:26
 * @desc : 对数组进行归并
 */
public class MergeSort {
    public void sort(int [] a){
        mergeSort(a);
    }

    public void mergeSort(int[]a ){
        int na = a.length;
        if (na < 2)
            return;
        int mid = na/2;
        int[] nl = new int[mid];
        int[] nr = new int[na-mid];
        for (int i = 0;i<=mid-1;i++)
            nl[i] = a[i];
        for (int j=mid;j <= na-1;j++ )
            nr[j-mid] = a[j];
        mergeSort(nl);
        mergeSort(nr);
        merge(a,nl,nr);
    }
    public void merge(int[] a, int[] leftA ,int [] rightA){
        int nl = leftA.length;
        int nr = rightA.length;
        int i = 0,j=0,k=0;
        while (i<nl && j<nr){
            if (leftA[i]<=rightA[j]){
                a[k++] = leftA[i++];
            }else {
                a[k++] = rightA[j++];
            }
        }
        while (i<nl){
            a[k++]= leftA[i++];
        }
        while (j < nr){
            a[k++] = rightA[j++];
        }
    }
    public static void main(String[] args) {
        int [] a = {45,12,88,9,5,678,321,17,19,10,52};
        System.out.printf("old array -> "+Arrays.toString(a)+"\n");
        new MergeSort().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }

}
