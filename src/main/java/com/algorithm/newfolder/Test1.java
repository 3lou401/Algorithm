package com.algorithm.newfolder;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/28
 * Time: 23:04
 * Description:
 *  在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 *  解题思路 ： 把i放到数组中i的位置， while(nums[i] != i) { swap(nums,i,nums[i])}
 *              交换之前，可以先判断一下， 如果nums[i] = nums[nums[i]] ,不用交换了，直接结束
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int [] nums = {2, 3, 1, 0, 2, 5};
        int [] res = new int[nums.length];
        test1.duplicate(nums,6,res);
        System.out.println(res.length+"");
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
       if (numbers == null || length < 0)
           return false;
       for (int i = 0; i< length;i++){
           while (numbers[i] != i){

               if (numbers[i] == numbers[numbers[i]]){
                   duplication[0] = numbers[i];
                   return true;
               }
               //比如 num[i]是3 ， 和 第三个位置交换，保证num[3] = 3
                swap(numbers,i,numbers[i]);
           }
       }
       return false;
    }

    private void swap(int [] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
