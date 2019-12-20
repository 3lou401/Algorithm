package com.dataStructure;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/20 13:58
 * @desc :  为什么引入树，树的优势
 */
public class SearchInAlgorithm<T extends  Comparable<T>> {
     T[] elementDatas;
    //1.  查找成功，返回该记录信息，或者是在集合中位值 ； 不存在，返回空记录或空指针
    public  T findK(){
        return null;
    }

    public SearchInAlgorithm() {
        Integer[] a = {5,16,39,45,51,98,100,202,226,321,368,444,501};
        elementDatas = (T[])a;
    }

    //2. 查找分为静态查找和动态查找 。
    // 静态查找 ：集合中记录是固定的，不涉及对记录的插入和删除
    // 动态查找 ：可能需要 修改集合

    //3. 查找的效率 ：静态查找，用 "平均查找长度"衡量， 比如下边的平均查找算法
    public int  findBySequential(T val){
        int k;
        for ( k = elementDatas.length;k>0;k--){
            if (elementDatas[k] == val){
                break;
            }
        }
        return k;
    }
    //4. 二分查找，前提是集合是有序的
    public int findByBinary(T val){
        // 省略判断集合非空
        int left =0,right=elementDatas.length - 1;
        while (left < right){
            int mid = (right+ left)/2  ;
            int k = elementDatas[mid].compareTo(val);
            if (k == 0)
                return  mid;
            else if (k > 0)
                right = mid -1 ;
            else
                left = mid+1;
        }
        return  -1;// 表示没有找到
    }

    public static void main(String[] args) {
        SearchInAlgorithm s = new SearchInAlgorithm();
        System.out.printf(""+s.findByBinary(444));
    }

}
