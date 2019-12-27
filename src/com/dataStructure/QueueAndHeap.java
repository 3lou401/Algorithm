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
    // 时间复杂度， 是这个完全二叉树（堆）的高度， O(logN)
    public void insert(T val){
        if (isFull()){
            return;
        }
        int index = ++size;
        // 上滤 ： 只要判断父亲是不是小于要插入值
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

        //数组下滤 ： 拿儿子中大值和X比较
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

//大根堆的建立
//  给定一个数组， 创建成大根堆
class MaxHeapUseCase{

    //思路1 ：一个个插入 , 时间复杂度是O(NlogN)
    public  MaxHeap<Integer> create1(int [] a){
        if (a == null || a.length < 1)
            return null;
        int alen =a.length;
        MaxHeap<Integer> mh = new MaxHeap<>(alen +1 );
        for (int i =0; i< alen;i++){
            mh.insert(a[i]);
        }
        return mh;
    }

    //思路2 ： 创建一个无序的完全二叉树 ， 将array看成完全二叉树的顺序存储结构
    public int[] buildMaxHeap(int[] array){
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for(int i=(array.length-2)/2;i>=0;i--){
            adjustDownToUp(array, i,array.length);
        }
        return array;
    }

    //将元素array[k]自下往上逐步调整树形结构
    private void adjustDownToUp(int[] array,int k,int length){
        int temp = array[k];
        for(int i=2*k+1; i<length-1; i=2*i+1){    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if(i<length && array[i]<array[i+1]){  //取节点较大的子节点的下标
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if(temp>=array[i]){  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            }else{   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
    }
}