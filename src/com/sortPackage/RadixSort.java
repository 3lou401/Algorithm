package com.sortPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/30 00:05
 * @desc : 基数排序 and 桶排序
 * 基数排序（radix sort）属于“分配式排序”（distribution sort），
 * 又称“桶子法”（bucket sort）或bin sort
 * 举例子
 *      假定现在有这样一个整型数组{21,56,88,195,354,1,35,12,6,7}，要进行排序
 *
 *  思路
 *      首先，看这些数的个位，把他们按照个位从小到大排序，得到 {21,1,12,354,195,35,56,6,7,88}
 *           从前往后，21，放到1号桶中（我们姑且先把他叫做桶），56放到6号桶中，88放到8号桶……放完之后，再把他们按顺序拿出来
 *      再按照十位进行排序，放入桶中，再拿出来
 *      再按照百位，放入桶中，拿出来
 */
public class RadixSort {
    public void fun() {
        int[] n = {421, 240, 35, 532, 305, 430, 124};
        radixSort(n);
        for(int i : n) {
            System.out.print(i + " ");
        }
    }
    //实现基数排序 LSD-从最低位开始排 MSD-从最高位开始排
    public void radixSort(int[] data) {
        int maxBin = maxBin(data);
        List<List<Integer>> list = new ArrayList<>();
        for(int i  = 0; i < 10; i ++) {
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0, factor = 1; i < maxBin; factor *= 10, i ++) {
            for(int j = 0; j < data.length; j ++) {
                list.get((data[j]/factor)%10).add(data[j]);
            }
            for(int j = 0, k = 0; j < list.size(); j ++) {
                while(!list.get(j).isEmpty()) {
                    data[k] = list.get(j).get(0);
                    list.get(j).remove(0);
                    k ++;
                }
            }
        }
    }
    //计算数组里元素的最大位数
    public int maxBin(int[] data) {
        int maxLen = 0;
        for(int i = 0; i < data.length; i ++) {
            int size = Integer.toString(data[i]).length();
            maxLen =  size > maxLen ? size : maxLen;
        }
        return maxLen;
    }
}