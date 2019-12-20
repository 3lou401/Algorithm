package com.dataStructure;

import java.security.cert.TrustAnchor;
import java.util.NoSuchElementException;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/14 15:06
 * @Desc: 线性表  概念 ： 前驱a - Anti_Polish - 后继a , 结构 ： 表头 - 表尾
 *  API 类
 */
public abstract class LinerList<T> {
    abstract void makeEmpty(); // 初始化线性表
    abstract T find(int index) throws Exception; //返回index位置的元素
    abstract T del(int index) throws Exception; //删除并返回index位置的元素
    abstract void add (T val,int index) throws Exception; //在index位置插入数据
    abstract  int size(); // 返回线性表的长度
}

// 线性表的顺序存储实现
class SequentialTable<T> extends LinerList<T>{
    T[] elementdatas;
    int size;
    private static int MaxSize = 1000;

    @Override
    void makeEmpty() {
      elementdatas = (T[]) new Object[MaxSize];
      size = 0;
    }

    @Override
    T find(int index) throws Exception {
        checkIndex(index);
        return elementdatas[index];
    }

    private void checkIndex(int index) throws Exception {
        if (index < 0 || index > size())
            throw new Exception("");
    }

    @Override
    T del(int index) throws Exception {
         checkIndex(index);
         checkEmpty();
         T res = elementdatas[index];
         for (int i = index; i< size() -1 ;i++){
             elementdatas[i] = elementdatas[i+1];
         }
         size--;
        return res;
    }

    private void checkEmpty() throws Exception {
        if (size() ==0)
            throw  new Exception("当前表数据为空");

    }

    //顺序表的插入 : 检查数组是否满，插入位置是否（0<=x<=size）, 倒序执行元素移动，插入元素，长度+1。
    //时间复杂度 为O(N)
    @Override
    void add(T val, int index) throws Exception {
        //倒序插入
         if(index > MaxSize )
             throw new Exception("数组已满");
         if (index < 0 || index > size())
             throw new Exception("插入位置不合法");
        int j;
         for( j = size(); j> index;j--){
             elementdatas[j] = elementdatas[j-1];
         }
         elementdatas[j] = val;
         size--;
    }

    @Override
    int size() {
        return size;
    }
}


//线性表的链式存储实现 : 数据结构 head ---> a1 ----> a2 ----> null , 表头指针
class LinkedTable<T> extends  LinerList<T>{

    private class Node<T>{
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<T> header; //如果header作为实际数据节点，写法略有不同，这里header作为一个空节点
    int size;

    @Override
    void makeEmpty() {
        header = new Node<>(null,null);
        size = 0;
    }

    @Override
    T find(int index) throws Exception {
       checkIndex(index);
       return node(index).value;
    }
    // header作为 空节点， 在表中下标index是0
    private Node<T> node(int index) {
        Node<T> keyN = header;
        for (int i = 0;i < index;i++){
            keyN = keyN.next;
        }
        return keyN;
    }

    // 0是header节点，非数据节点
    private void checkIndex(int index) throws Exception {
        if (index <= 0 || index > size())
            throw  new Exception("index不合法");
    }

    @Override
    T del(int index) throws Exception {
        checkIndex(index);

        Node<T> prev = node(index - 1);
         Node<T> ndel = prev.next;
         T res = ndel.value;

         prev.next = ndel.next; //修改前一个节点的指向

         ndel.next = null;
         ndel.value = null;// GC
        size--;
        return res;
    }

    // 插入是在表的 1<= x <= size +1 位置插入
    @Override
    void add(T val, int index) throws Exception {
        if (index <1 || index > size() +1){
            throw  new Exception("插入位置不合法");
        }
        Node<T> prev = node(index - 1);
        final Node<T> newNode = new Node<>(val,prev.next);
        prev.next = newNode;
        size++;
    }

    @Override
    int size() {
        return size;
    }
}