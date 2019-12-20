package com.sort;
import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/18 23:44
 * @Desc: 桶排序
 */
public class BucketSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //常用写法
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            //桶数组此下标有数据，数值就加一
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
    public static void main(String[] args) {
        int [] a = {45,12,88,9,5,678,321,17,19,10,52};
        System.out.printf("old array -> "+ Arrays.toString(a)+"\n");
        new BucketSort().sort(a);
        System.out.printf("new array -> "+Arrays.toString(a));
    }
}