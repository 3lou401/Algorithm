package com.dataStructure;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/15 20:16
 * @Desc:  有穷线性表 ，先进先出
 */
public abstract class MyQueue<T> {

    abstract  boolean isEmpty();
    abstract  boolean isFull();
    abstract void addQueue(T val) throws Exception;//入队列
    abstract  T delQ() throws Exception; //出队列
}

// 队列的顺序实现，注意的点 ，
// 采用数组+前后指针的结构，如果添加一个（前指针++），删除一个（后指针++），
// 出现前后指针都指向末尾，数组没有数据，需要将指针指向起始位置
class SequentialQueue <T> extends MyQueue<T>{

    T [] elementDatas;

    int front; //队头 从队列头部删除数据
    int rear;// 队尾 从队列尾部插入数据，控制添加

    int maxSize;


    public SequentialQueue() {
        maxSize =20;
        elementDatas = (T[]) new Object[20];
        front = rear = -1;
    }

    @Override
    boolean isEmpty() {
        return ( rear +1 ) % maxSize == front;
    }

    @Override
    boolean isFull() {
        return front == rear;
    }
    // 添加的时候，尾部指针不停往前走
    @Override
    void addQueue(T val) throws Exception {
        if (isFull())
            throw  new Exception("队列已满");
        rear = (rear +1 )% maxSize;
        elementDatas[rear] = val;
    }

    //删除时，头部指针向前走
    @Override
    T delQ() throws Exception {
        if (isEmpty()){
            throw new Exception("队列为空");
        }
        front = (front + 1) % maxSize;
        return  elementDatas[front];
    }
}

//也是顺序存储，不同地方在于，一个是通过 rear == front 判断空， (rear + 1)%maxSize 判断队列满
//此处引入辅助参数 size ,添加的时候 size + , 删除的时候size-
class SequentialQueue2 <T> extends MyQueue<T>{

    T [] elementDatas;

    int front; //队头 从队列头部删除数据
    int rear;// 队尾 从队列尾部插入数据，控制添加

    int maxSize;
    int size;


    public SequentialQueue2() {
        maxSize =20;
        elementDatas = (T[]) new Object[20];
        front = rear = -1;
        size = 0;
    }

    @Override
    boolean isEmpty() {
        return size == 0;
    }

    @Override
    boolean isFull() {
        return size == maxSize;
    }
    // 添加的时候，尾部指针不停往前走
    @Override
    void addQueue(T val) throws Exception {
        if (isFull())
            throw  new Exception("队列已满");
        rear = (rear +1 )% maxSize;
        // 取余的目的是，到数组尾部之后，可以继续从开始位置继续添加 （没有满，说明开始位置是空的）
        elementDatas[rear] = val;
        size++;
    }

    //删除时，头部指针向前走
    @Override
    T delQ() throws Exception {
        if (isEmpty()){
            throw new Exception("队列为空");
        }
        front = (front + 1) % maxSize;
        size--;
        return  elementDatas[front];

    }
}


//链式实现队列 : 和顺序存储不同，不需考虑循环队列
class LinkedQueue <T> extends  MyQueue<T>{

    private  class Node<T> {
        Node<T> next;
        T value;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }
    }

    Node<T> front,rear;

    public LinkedQueue() {
    }

    @Override
    boolean isEmpty() {
        return front == null;
    }
    //链式的，不考虑满的情况
    @Deprecated
    @Override
    boolean isFull() {
        return false;
    }

    @Override
    void addQueue(T val) throws Exception {
        Node<T> newNode = new Node<>(null,val);
        if (rear == null){
            front = rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    T delQ() throws Exception {
        if (isEmpty())
            throw  new Exception("没有元素");
         Node<T> frontCell = front;
         T res = frontCell.value;
         if (frontCell.next == null){
             front = rear = null;
         }else {
             front = frontCell.next;
             frontCell.next = null;
         }
        return res;
    }
}

//顺序实现Dequeue( 双端队列)
//分析 ： 队列 头尾 ，正常情况下， 尾部入队列（add）头部出队列（remove）; 对应代码就是 rear++和front++
// 双旦队列，加上头部入队列和尾部出队列，对应（front--）和（rear--）
// 因为实际数据是 front--> rear

class MyDequeue<T>{
    T [] elementDatas;
    int front, rear;
    private  final  int max_size = 100;

    public MyDequeue() {
        elementDatas = (T[]) new Object[max_size];
        front = rear = -1;
    }

    // 省略其他方法
    public void enqueue(T val){
        if( (front + 1)% max_size == rear ){
            System.out.printf("队列已满");
            return;
        }
        rear = (rear+1)%max_size;
        elementDatas[rear] = val;
    }

    public T dequeue(){
        if (front == rear){
            System.out.printf("");
            return null;
        }

    }
}
