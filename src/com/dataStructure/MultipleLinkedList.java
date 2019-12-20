package com.dataStructure;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/14 17:09
 * @Desc: 多重链表 和 广义表
 *  广义表 举例 ： 张三是 开发一部的，他有三个组员job cucci tony ; 李四是开发二部的 ，有两个组员 小刘、小张。
 *  表示如下 {张三，{job,cucci,tony}},{李四，{小刘，小张}}
 */
public class MultipleLinkedList<T> {

    //多重链表
    private  class Node<T>{
        T value;
        Node<T> son;
        Node<T> next;
    }



}
