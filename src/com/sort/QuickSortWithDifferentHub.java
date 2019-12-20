package com.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/20 12:54
 * @desc : 用不同的枢纽元策略，执行快速排序
 *       :
 */
public class QuickSortWithDifferentHub {

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int pIndex = patition1(a, left, right);
        quickSort(a, left, pIndex - 1);
        quickSort(a, pIndex + 1, right);
    }

    //利用开始元素，中间元素，和结尾元素中间的中间值作为 枢纽元素
    private int patition(int[] a, int left, int right) {
//        int pivot = median()
        return 1;
    }

    // 利用随机数
    private int patition1(int[] a, int left, int right) {
        Random random = new Random();
        int pIndex = random.nextInt(right-left+1)+left;
        //做一次交换，把pivot交换到队尾（或者队首）
        swap(a,pIndex,right);
        int pivot = a[right];
        int i = left ;
        for(int j = left;j <right;j++){
            // 把小于枢纽的值交换到左边
            if (a[j] < pivot){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,right,i); //把之前放到最右边的枢纽值，交换到已经分好左右的数组对应位置
        System.out.println("pIndex["+i+"] -> "+Arrays.toString(a));
        return i;
    }


//    private int

    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int [] a = {45,12,88,9,5,678,321,17,19,10,52};
        System.out.printf("old array -> "+Arrays.toString(a)+"\n");
        new QuickSortWithDifferentHub().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }
}
