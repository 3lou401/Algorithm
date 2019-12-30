package com.sortPackage;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/29 23:59
 * @desc ：根据排序的策略，将排序分为几块，这是第一块， 选择的方式进行排序 。
 *  选择的策略进行排序的，有两种， 选择排序  and  堆排序
 *  分析下边的两种排序方式，都是从数组中选择一个值，要么选择最小值放到前边，要么选择最大值放到后边
 *  不同的是， 简单排序是查找N-1,每次都是遍历未排序数组找最小值
 *  堆排序是，先维护一个大根堆，然后for循环，做下边操作，将a[0]和数组尾部交换，将交换后不平等的数组重新维护好
 */
public class SelectSort {
}
//简单选择排序 ：未排序序列中，选出最小值（或者最大值）和队首元素交换
class SimpleSelect<T extends Comparable<T>>{
    public T[] sort(T[] arr){
        if (arr.length < 0)
            return arr;
        for (int i=0;i<arr.length - 1;i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length;j++){
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex =j;
                }
            }
            swap(arr,i,minIndex);
        }
        return arr;
    }
    public void swap(T[] a ,int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}



//堆排序 ： 输出小根堆（或大根堆）的栈顶元素，重新生成堆
class  HeapSort<T extends Comparable<T>>{
     public void heapSort(T[] arr){
         if (arr.length <= 0)
             return;
         int N = arr.length;
         //先创建大根堆 ： 从最小节点的父亲开始下滤，循环操作，一直到大于0的元素全部下滤完成
          for (int i = (N-1)/2 ; i > 0 ;i--){
              percdown(arr,i,N);
          }
         //
          for (int j = N-1 ; j> 0;j--){
              swap(arr,0,j); //把最大根删除
              percdown(arr,0,j); // 最后一个数是被剔除堆的
          }
         //堆顶元素放到数组尾部 ， 重新生成堆
     }
    public void swap(T[] a ,int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
     //注意 ： 默认的数组，0的位置也会被使用，所以父子关系修改 为2*i+1 2*i+2
    //下滤的时候，默认只有i位置的元素是不合适的，通过下滤给其找到合适位置
    private void percdown(T[] arr, int i, int n) {
         int par,child;
         T needModifyEle = arr[i];
         for (par =i; par*2+1 < n; par =child){
             child = par * 2 + 1;
             if (child+1 < n && arr[child+1].compareTo(arr[child])>0){
                 child++;
             }
             if (arr[par] .compareTo(arr[child]) >= 0)
                 break;
             else
                 arr[par] = arr[child];

         }
         arr[par] = needModifyEle;
    }
}
