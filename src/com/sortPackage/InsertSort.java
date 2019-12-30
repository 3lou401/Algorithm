package com.sortPackage;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/30 00:01
 * @Desc : 利用插入的方式，进行排序。
 *   插入排序 and 希尔排序（变种）
 */
public class InsertSort {
}

//简单插入排序 ： 思路就是将数组分为已排序和未排序两个部分，拿未排序的元素插入到已排序数组中
class SimpleInsertSort<T extends Comparable<T>>{

    public void sort(T[] a){
        int N = a.length;
        for (int i = 0; i< N-1;i++){
            int j = i +1;
            T key = a[j];
            //TODO 易错点 ： 比较的是 j-1 开始的，千万别是j
            for ( ; j >0 && key.compareTo(a[j-1]) < 0 ;j--){
                    a[j] = a[j-1];
            }
            a[j] = key;
        }
    }

}

//希尔排序： 利用增量序列递减，最终减成希尔排序
class ShellSort<T extends Comparable<T>>{
    public void sort(T [] arr){
        int n = arr.length;
        int grap = 1;
        while (grap < n /3)
            grap = grap*3 +1;

        while (grap > 0){

            for (int i = grap; i< n-1;i++){
                int j = grap+1;
                T temp = arr[grap+1];
                for (; temp.compareTo(arr[j-grap]) < 0; j-=grap){
                    arr[j] = arr[j-grap];
                }
                arr[j] = temp;
            }


            grap/=3;
        }

    }
}