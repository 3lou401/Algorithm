package test;

import java.util.Scanner;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/30 19:42
 * @Desc: 排序 ：一亿个数取100 ， topK , 思路 小根堆
 */
public class TopK {

    public void solution(){
        int [] a = new int[100];
        int N = a.length ;
        for (int i = (N-1)/2;i > 0;i-- ){
            percdown(a,i,N);
        }

        //每读入 一个数 ，判断是否大于最小值
        Scanner in = new Scanner(System.in);
        for (int i =  100; i < 100000000;i++){
            int num = in.nextInt();
            if (num <= a[0]){
                continue;
            }else{
                a[0] = num;
                percdown(a,0,N);
            }
        }

    }

    private void percdown(int [] a, int index, int aSize){
        int par ,child;
         int aKey = a[index];
        for (par = index; par*2+1 < aSize; par = child){
            child = par * 2 +1;
            if (child+1 < aSize && a[child+1] < a[child] )
                child++;
            if (a[child] > aKey)
                a[par] = a[child];
            else
                break;
        }
        a[par] = aKey;
    }

}
