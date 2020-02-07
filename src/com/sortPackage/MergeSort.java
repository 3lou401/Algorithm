package com.sortPackage;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/30 00:03
 * @desc: 利用分治的思想，进行排序
 *  归并排序 : 将两个已经有序的子序列，归并成一个有序序列
 *  过程 ：
 *  1. 申请一个额外空间，用于存储归并两个子序列的结果
 *  2. 设置两个指针分别指向两个子序列的首位置，
 *  3. 比较这两个指针指向的值，小的值入空间，指针下移
 *  4. 两个数组中剩下的部分移入 这个空间
 *
 *  归并排序，时间复杂度是O(NlogN), 比较N次，递归logN次
 *      虽然时间复杂度不高，但是经常的开辟空间和数组间的copy也是很耗时，常用语外部排序
 */
public class MergeSort<T extends  Comparable<T >> {
    public void sort(T[] arr){
        T [] temp = (T[]) new Object[arr.length]; //TODO ERROR 报错
        mergeSort(arr,temp,0,arr.length-1);
    }
    //temp只是为了只new一次临时数组
    public void mergeSort(T [] arr, T [] temp, int left,int right){
        if (left < right){
            int center = (right+left)/2;
            mergeSort(arr,temp,left,center);
            mergeSort(arr,temp,center + 1,right);
            merge(arr,temp,left,center+1,right); // 合并这两段数据
        }
    }
    public void merge(T[] arr, T [] temp, int left,int center,int right){
//        T [] temp = (T[]) new Object[arr.length]; //每次合并都new数组，太耗费时间内存了
        int i= left,j = center,k=left;
        while (i < center && j  <= right){
            if (arr[i].compareTo(arr[j]) > 0){
                temp[k++] = arr[j++];
            }else {
                temp[k++] = arr[i++];
            }
        }
        while (i < center){
            temp[k++] = arr[i++];
        }
        while (j <= right){
            temp[k++] = arr[j++];
        }
        //temp copy回 arr
        int numAdd = right - left +1;
        for (int m = 0; m < numAdd;m++,right--){
            arr[right] = temp[right];
        }
    }

    public static void main(String[] args) {
        String[] a = {"3","1","7","4","5"};
        new  MergeSort<String>().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }
}
