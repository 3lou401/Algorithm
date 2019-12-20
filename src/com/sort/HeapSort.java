package com.sort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/8 17:23
 */
public class HeapSort {
   public void sort(int [] a){
        //1. 将数组堆序
       buildMaxHeap(a);
       int n = a.length;
       for (int i = n -1 ;i > 0;i--){
           swap(a,i,0);
           maxHeap(a,i,0);
       }
   }
   private void buildMaxHeap(int[] array){
       if (array == null || array.length <= 1) {
           return;
       }

       int half = array.length / 2;
       for (int i = half; i >= 0; i--) {
           maxHeap(array, array.length, i);
       }
   }
   private void maxHeap(int []a,int heapSize,int index){
       //和二叉堆不同的是，二叉堆一般选择从下标1开始，而这个数组会从下表0开始`
        int left = index * 2 +1;
        int right = index * 2 +2;

        int largest = index;
        /** 下边的两个if判断找出父亲 左右儿子中的最大值**/
        //注意第一个比较的是index和它的左儿子 left
        if (left < heapSize && a[left] > a[index]){
            largest = left;
        }
        //如果第一步 左儿子比父亲大，最大值就是左儿子， 下边的比较就是 左儿子和右儿子比较
        if (right < heapSize && a[right] > a[largest]){
            largest = right;
        }
        if (index != largest){
            swap(a,index,largest);
            maxHeap(a,heapSize,largest);
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
        new HeapSort().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }
}
