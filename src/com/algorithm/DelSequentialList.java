package com.algorithm;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/17 19:02
 * @Desc: 给定一个顺序存储的线性表，删除 小于min大于max的元素
 */
public class DelSequentialList {
    public static void main(String[] args) {
        int [] a= {4,2,11,3,7,8,0,-4,19};
       int[] b =   del(a,5,9);
        System.out.printf(b.length+"");
    }

    // 思路 遇到 符合删除条件的 就 自增，需要保留的，就移到前边去，最后只要前边的数组
    private static int[] del(int[] a, int min, int max) {
        if (a == null || a.length < 1)
            return null;
        int count = 0; //统计要删除的元素
        for (int i = 0; i<a.length;i++){
            if (a[i] > min && a[i] < max){
                count++;
            }else{
                a[i-count] =a[i];
            }
        }
        return  Arrays.copyOf(a,a.length-count);
    }
}
