package com.dataStructure;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/14 17:37
 * @Desc: 堆栈（stack） , 先进后出的数据结构，
 * 掌握堆栈的用法 ，
 *      比如， 给定一个入栈顺序，判断哪个出栈序列不合理
 *      比如，求解一个多项式的计算
 *
 */
// 堆栈的抽象API
public abstract class MyStack<T> {
    abstract  void createStack(int MaxSize);// 创建一个空的堆栈
    abstract  boolean isFull(); //是否满了
    abstract  boolean isEmpty(); //是否为空
    abstract boolean push(T val);// 入栈
    abstract T pop() throws Exception;//出栈
}

// 堆栈的顺序实现 :
// 数据结构 ： 一个数组 ，一个栈顶位置（从-1开始）
class SequentialStack<T> extends  MyStack<T>{

    private  T[] elementDatas;
    private  int top;

    @Override
    void createStack(int MaxSize) {
        this.elementDatas = (T[]) new Object[MaxSize];
        this.top = -1;
    }

    public SequentialStack() {
        createStack(20);
    }

    @Override
    boolean isFull() {
        return top == elementDatas.length - 1;
    }

    @Override
    boolean isEmpty() {
        return top < 0 ;
    }

    @Override
    boolean push(T val) {
        if (isFull()){
            return false;
        }
        elementDatas[++top] = val;
        return true;
    }

    @Override
    T pop() {
        if (isEmpty())
            return null;
         T res = elementDatas[top--];
        return res;
    }

    public static void main(String[] args) {
        SequentialStack<Integer> ss = new SequentialStack<>();
        ss.createStack(10);
        System.out.printf(""+ss.pop());
        ss.push(12);
        System.out.printf("ss.val--"+ss.pop());
    }
}


//用一个数组实现两个栈，尽可能的利用空间
class SequentialStackUseCase1<T>{

    T [] elementDatas;
    int top1;  // 栈1的引用
    int top2; //栈2

    void createStack(int MaxSize) {
        elementDatas = (T[]) new Object[MaxSize];
        top1 = -1;
        top2 = MaxSize;
    }

    boolean push(T val,int flag) {
        if(top2 - top1 ==1)
            return false;
        if (flag == 1){
            elementDatas[++top1] = val;
        }else {
            elementDatas[--top2] = val;
        }
        return false;
    }

    T pop(int flag) throws Exception {
        if (flag == 1){
            if (top1 == -1){
                throw  new Exception("栈1没有数据");
            }
            return  elementDatas[top1--];
        }else {
            if (top2 == elementDatas.length)
                throw  new Exception("栈2没有数据");
            return elementDatas[top2++];
        }
    }
}

//链式存储，实现堆栈（Stack）
class LinkedStack<T> extends  MyStack<T>{

    private class  Node<T>{
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    Node<T> top;
    int size;
    int MaxSize;

    @Override
    void createStack(int MaxSize) {
        top = new Node<>(null,null);
        MaxSize = MaxSize;
        size = 0;
    }

    @Override
    boolean isFull() {
        return size == MaxSize;
    }

    @Override
    boolean isEmpty() {
        return size == 0;
    }

    //入栈, 相当于是addFirst, 新节点的next指向旧的开始节点（top）
    private void addFirst(T val){
        Node<T> newNode = new Node<>(val,null);
        if (top == null){
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }
    @Override
    boolean push(T val) {
        if(isFull()){
            return false;
        }
       addFirst(val);
        return true;
    }

    @Override
    T pop() throws Exception {
        if (isEmpty()){
            throw  new Exception("没有数据");
        }
        T val = top.data;
        top = top.next;
        size--;
        return val;
    }
}

//测试用例 ： 利用堆栈，求解多项式计算，比如2+5*3-4*(1+2)
class TestStack{
    public static void main(String[] args) throws Exception {
        MyStack<Integer> nums = new SequentialStack<>();
        MyStack<Character> ops = new SequentialStack<>();

            nums.push(1);
            nums.push(2);
            nums.push(3);
        System.out.printf("num-"+nums.pop());
        }

}
