package com.algorithm;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/17 20:01
 * @Desc: 返回链表中倒数第M个数，不改变链表结构
 */
public class MIndexLinkedList {
    private  class Mylinked{

        Node begin;
        int size;
    }
    private class Node{
        int value;
        Node next;
    }
    public static void main(String[] args) {

    }
    public int find(Mylinked l, int m){
        int [] a = new int[l.size];
        int i = 0;
        Node fir = l.begin;
        while (fir != null){
            a[i++] = fir.value;
            fir = fir.next;
        }
        if (a.length - m > 0){
            return  a[a.length-m];
        }
        return -99999; //表示出错
    }
}
