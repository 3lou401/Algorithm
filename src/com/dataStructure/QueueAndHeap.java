package com.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/23 21:09
 * @Desc:
 */
public class QueueAndHeap {
}

// 队列的特点是先进先出
class QueueUseCase{
    public static void main(String[] args) {
        Queue<Integer> q  = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        System.out.printf("--"+q.poll());

    }
}

// 某些场景下,如 A打印1000页，B打印2页，B对A说，可否插队，
// 满足类似上边场景,引入优先队列,也叫堆

//堆的定义
//堆是特殊的队列, 从堆中取元素是按照优先级顺序


//堆的常见实现形式
// "数组存储"的"完全二叉树" 表示 堆

//堆的特性
// 0不存储数据,从下标为1的开始存储; 下标为i的元素，它的左儿子是2i,右儿子是2i+1
// 部分有序性，比如大根堆是 父亲大于儿子 ,兄弟节点之间大小关系不确定

class MaxHeap<T extends Comparable<T>>{
    T[] elementDatas;
    int size;
    int capacity;

    public MaxHeap(int MaxSize) {
        elementDatas = (T[]) new Object[MaxSize+1];
        capacity = MaxSize;
        size = 0;
    }
    public boolean isFull(){
        return size == capacity;
    }
    public void insert(T val){
        if (isFull()){
            return;
        }
        int index = ++size;
        for (;elementDatas[index/2].compareTo(val) < 0;index /=2){
            elementDatas[index] = elementDatas[index/2];
        }
        elementDatas[index] = val;

    }

    public boolean isEmpty(){
         return size == 0;
    }
    public T deleteMax(){
        if (isEmpty()){
            return null;
        }
        T val = elementDatas[1];

        int parent ,child;
        T x = elementDatas[size--]; // 表示最后一个值没有了，下边空出位置之后，需要赋值x

        //数组下滤
        for(parent = 1; parent* 2 < size;){
            child = parent * 2;
            //找出左右儿子中较大值
            if (child +1 < size &&elementDatas[child+1].compareTo(elementDatas[child]) >0)
                 child++;
            if (x.compareTo(elementDatas[child]) > 0)
                break;
            else
                 elementDatas[parent] = elementDatas[child];
            parent = child;
        }
        //parent就是要插入的位置
        elementDatas[parent] =  x;

        return val;
    }

}