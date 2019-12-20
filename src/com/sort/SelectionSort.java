package com.sort;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/15 11:38
 * @desc : 选择排序
 */
public class SelectionSort {

    public void sort(int[] a) {
        if (a.length < 2)
            return;
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex])
                    minIndex = j;
            }
            swap(a, minIndex, i);

        }
    }


    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {45, 12, 88, 9, 5, 678, 321, 17, 19, 10, 52};
        System.out.printf("old array -> " + Arrays.toString(a) + "\n");
        new SelectionSort().sort(a);
        System.out.printf("new array -> " + Arrays.toString(a));
    }
}
