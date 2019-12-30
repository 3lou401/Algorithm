package com.sortPackage;

import java.util.logging.Level;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/30 00:02
 * @desc: 利用交换的方式，进行排序
 *    冒泡 and 快排
 */
public class SwapSort {
}

class BubbleSort<T extends Comparable<T>>{

    public void sort(T [] arr){
        int N = arr.length;
        boolean flag = false ;//  额外加的，判断是否是已经有序状态
        for (int i = 0; i < N -1 ; i++){
            for (int j = 0; j <N-1-i;j++){
                if (arr[j].compareTo(arr[j+1]) > 0){
                    swap(arr,j,j+1);
                    flag = true;
                }
            }
            if (!flag){
                //没有发生交换， 全部有序 , 就不用扫描了，节省点时间
                break;
            }
        }
    }
    public void swap(T[] a ,int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

//快速排序 ： 指针交换的方式 实现快速排序
//TODO 特别特别特别 容易失误的地方， 基准元素放在left时，一定是右侧哨兵先动
// 原因 ： 如果左侧哨兵先动， 走到一个大于大于基准元素的地方停止，（万一右侧也是到这个节点），
// 循环结束，在交换基准元素和哨兵指向元素后，会发现结果不对，左边有比基准元素大的
class QuickSort<T extends Comparable<T>>{
    public void swap(T[] a ,int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public void Qsort(T[]arr , int startIndex,int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        //得到基准元素位置
        int patition = partition(arr, startIndex, endIndex);
        Qsort(arr,startIndex,patition-1);
        Qsort(arr,patition+1,endIndex);
    }
    //获得基准元素， 将数组分为左有两块，左边小于基准元素 & 右边大于基准元素
    private int partition(T[] arr, int left, int right) {
        int pivotIndex = left;
        T pivot =  arr[left]; // pivot ：基准元素选择，这里选择左边
        while (left <= right){
            while (left < right && arr[right].compareTo(pivot) >= 0)
                right--;
            while (left < right && arr[left].compareTo(pivot) <= 0)
                left++;
            if (left < right){
                swap(arr,left,right);
            }
        }
        //left和pivot
        swap(arr,pivotIndex,left);
        return left; // left左边数组小于left, 右边数组大于left
    }
}

// 快速排序2 : 思路和上边一直，不同地方在于， 基准元素选择left center right三个数的中位数，然后在放到left
class QuickSort2<T extends Comparable<T>>{
    public void swap(T[] a ,int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //求数组中start 、end、center
    private T median(T[] a, int start, int end) {
        int center = (start +end) /2;
        if (a[start].compareTo(a[center]) > 0){
            swap(a,start,center);
        } // start < center
        if (a[center].compareTo(a[end]) > 0){
            swap(a,end,center);
        } // center < end
        if (a[start].compareTo(a[end]) > 0){
            swap(a,start,end);
        } // start < end

        //将基准元素放到左边
        swap(a,start,center);
        return a[start];
    }


    public void Qsort(T[] a,int start, int end){
        T median = median(a,start,end);
        int low = start,high=end;
        while (true){
            while (low < high && a[low].compareTo(median) <= 0)
                low++;
            while (low <high && a[high].compareTo(median) >= 0)
                high--;
            if (low < high)
                swap(a,low,high);
            else
                break;
        }
        swap(a,start,low); //low此时是基准元素下标
        Qsort(a,start,low-1);
        Qsort(a,low+1,high);

    }

    public void sort(T[] arr){
        Qsort(arr,0, arr.length-1);
    }


}