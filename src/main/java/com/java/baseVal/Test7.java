package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/29
 * Time: 15:16
 * Description: 数组
 */
public class Test7 {
    public static void main(String[] args) {
        //数组定义
        int [] a = {1,3,4,12};
        int [] b = new int[5];
        b= new int[]{1,1,1,1,1};

        //多维数组 : 必须指定高维
        int [][] c = new  int[5][];
        int [][] d = {{1,3,4},{2,5,6}};
        for (int i =0 ;i < 2;i++){
            //多少行 ，每一行都是一个数组
            for (int j = 0;j<3;j++){
                System.out.println(d[i][j]);
            }
        }
        System.out.println("other ----");
        //二维数组，不能处理每一个元素，也必须先按行处理，每行都是一个数组
        //换句话说，本质上，Java没有多维数组，二维数组不过是数组的数组

        for (int[] temp : d){
            for (int k: temp){
                System.out.println(k);
            }
        }
    }
}

