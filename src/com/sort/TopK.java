package com.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: leaderHoo
 * @Date: 2019/4/2 15:45
 * @desc : 从N个数中查找，前K个数
 *
 *思路：
 *      先维护一个K个数的小根堆。
 *      每读入一个数，和堆顶元素比较，只要大于堆顶元素，就替换
 */
public class TopK {

//    从五十个数中，找出前10个最大数
    public static void main(String[] args) {

        int size = 50; //从50个数中取前10
        int key = 10;

        int [] a = new int[key];

        int [] b = new int[size]; //用于保存原数组

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i< key;i++){
            int temp = scanner.nextInt();
            a[i] = temp;
            b[i]=temp;
        }

        buildHeap(a);
        System.out.printf("第一次数组 a[] is " +Arrays.toString(a)+"\n");
        for (int i = key ; i < size;i++){
            int temp = scanner.nextInt();
            b[i]=temp;
            if (temp <= a[0]){
                continue;
            }else{
                a[0] = temp;
                minHeap(a,0,key);
            }
            System.out.printf("a[]第"+i+"比较 " +Arrays.toString(a)+"\n");
        }
        System.out.printf("多次输入的数据是 b[] is " +Arrays.toString(b)+"\n");
        System.out.printf("前"+key+"位数据是 " +Arrays.toString(a)+"\n");


    }

    public  static  void buildHeap(int [] array){
        if (array == null || array.length <= 1) {
            return;
        }

        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            minHeap(array, i, array.length);
        }
    }

    public static void minHeap(int[] a,int index,int heapSize){
        //和二叉堆不同的是，二叉堆一般选择从下标1开始，而这个数组会从下表0开始`
        int left = index * 2 +1;
        int right = index * 2 +2;

        int min = index;
        /** 下边的两个if判断找出父亲 左右儿子中的最小值**/
        if (left < heapSize && a[left] <= a[index]){
            min = left;
        }
        if (right < heapSize && a[right] <= a[min]){
            min = right;
        }
        if (index != min){
            swap(a,index,min);
            minHeap(a,min,heapSize);
        }
    }

    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
