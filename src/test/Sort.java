package test;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/30 19:59
 * @Desc:
 */
public class Sort {
    public void swap(int []a ,int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}

class SimpleSelectSort extends  Sort{

    public void sort(int [] a){
        int N = a.length;
        for(int i = 0; i <N-1;i++){
            int minIndex = i;
            for (int j = i+1 ;j < N;j++){
                if (a[j]  < a[minIndex])
                    minIndex = j;
            }
            swap(a,minIndex,i);
        }
    }

    public static void main(String[] args) {
        int [] a = {3,5,6,1,12,4,7,9,2};
        new SimpleSelectSort().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }
}

class HeapSort extends Sort{

    public void sort(int [] a){
        int n = a.length;
        for (int i = (n-1)/2; i >= 0;i--){
            percdown(a,i, n);
        }
        for (int i =  n-1 ; i > 0 ;i--){
            swap(a,0,i);
            percdown(a,0,i);
        }

    }
    //大根堆，下滤时，找儿子最大值
    private void percdown(int [] a,int index, int alen){
        int aKey = a[index];
        int par,child;
        for (par = index; par*2 +1 < alen; par = child){
            child = par * 2 +1;
            if (child+ 1 < alen && a[child] < a[child+1])
                child++;
            if (aKey > a[child])
                break;
            else
                a[par ] = a[child];
        }
        a[par] = aKey;
    }

    public static void main(String[] args) {
        int [] a = {3,5,6,1,12,4,7,9,2};
        new HeapSort().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }
}

class SimpleInsertSort extends Sort{


    public void sort(int [] a){
        int N = a.length;
        for (int i = 0; i < N-1;i++){
            int j = i+1;
            int akey = a[j];
            for (; j > 0 && a[j-1] > akey; j--)
                a[j] = a[j-1];
            a[j] = akey;
        }
    }


    public static void main(String[] args) {
        int [] a = {3,5,6,1,12,4,7,9,2};
        new SimpleInsertSort().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }

}

class ShellSort extends Sort{

    //TODO 易错点 ， i = grap时， j = i 开始循环到 j - grap>= 0 ; 第二个地方是比较的 a[j-grap]
    public void sort(int [] a){
        //先求grap
        int n = a.length;
        int grap = 1;
        while (grap * 3 < n)
            grap =grap *3+ 1;
        while (grap >= 1 ){
            for (int i = grap; i <n;i++){
                int j = i;
                int aKey = a[j];
                for (;j >= grap && a[j-grap] > aKey;j-=grap)
                    a[j] =a[j-grap];
                a[j] = aKey;
            }
            grap/=3;
        }
    }
    public static void main(String[] args) {
        int [] a = {3,5,6,1,12,4,7,9,2};
        new ShellSort().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }

}

class BubbleSort extends Sort{
    public void sort(int []a){
        int n = a.length;
        for (int i = 0 ; i< n;i++){
            for (int j =0; j < n-i-1 ;j++){
                if (a[j] > a[j+1])
                    swap(a,j,j+1);
            }
        }
    }
    public static void main(String[] args) {
        int [] a = {3,5,6,1,12,4,7,9,2};
        new BubbleSort().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }

}

//TODO 特别特别特别 容易失误的地方， 基准元素放在left时，一定是右侧哨兵先动
class QuickSort extends  Sort{

 public void quickSort(int[] a,int left,int right){
     if (left >= right)
         return;
     int patition = patition(a,left,right);
     quickSort(a,left,patition-1);
     quickSort(a,patition+1,right);
 }
 private  int patition(int []a,int left,int right){
     int pivot = a[left];
     int low = left,high = right;
     while (low < high){
         while (low <high && a[high] >= pivot)
             high--;
         while (low <high && a[low] <= pivot)
             low++;
         if (low < high )
             swap(a,low,high);
     }
     swap(a,left,low);
     return low;
 }
 public void sort(int [] a){
     quickSort(a,0,a.length-1);
 }

    public static void main(String[] args) {
        int [] a = {3,5,6,1,12,4,7,9,2};
        new QuickSort().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }
}

//关键在于临时数组
class MergeSort extends  Sort{
    public  void sort(int []a){
        int [] temp = new int[a.length];
        mergeSort(a,temp,0,a.length-1);
    }
    public void  mergeSort(int []a ,int [] temp ,int left,int right){
        if (left < right){
            int center = (left + right)/2;
            mergeSort(a,temp,left ,center);
            mergeSort(a,temp,center+1,right);
//
            merge(a,temp,left,center+1,right);// TODO 错误的地方是，中间参数需要的是右边数组的开始下标，应该是center+1
        }
    }
    //TODO 不要忘了 copy回去, 注意copy的写法，应该只copy从left到right这么长
    public void merge(int [] a,int [] temp ,int left,int rightIndexBegin,int rightIndexEnd){
        int i = left ,j = rightIndexBegin,k=left;
        while (i< rightIndexBegin && j <= rightIndexEnd){
            if (a[i] < a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while (i <rightIndexBegin)
            temp[k++] = a[i++];
        while (j <= rightIndexEnd)
            temp[k++] = a[j++];

        int numMerge = rightIndexEnd -left + 1;
        //TODO 只copy 归并的这些数
        for (int m = 0; m < numMerge;m++,rightIndexEnd--)
            a[rightIndexEnd] = temp[rightIndexEnd];
    }

    public static void main(String[] args) {
        int [] a = {3,5,6,1,12,4,7,9,2};
        new MergeSort().sort(a);
        System.out.printf("--"+ Arrays.toString(a));
    }
}