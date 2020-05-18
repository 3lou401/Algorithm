package com.algorithm.newfolder;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/28
 * Time: 23:47
 * Description:
 *
 *
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，
 * 然后倒过来按上三角中的分布规律，把另一部分也乘进去
 */
public class Test2 {
    public int[] multiply(int[] A) {
        if (A == null || A.length < 0)
            return null;
        //除了矩阵中间，其他的都要乘
        int[]B = new int[A.length];
        B[0] = 1;
        //计算下三角
        for (int i = 1;i <A.length;i++){
            B[i] *=B[i-1] * A[i-1];
        }
        int temp = 1;
        for (int j = A.length -2; j>= 0 ;j--){
            temp *= A[j+1];
            B[j] *=temp;
        }
        return B;
    }
}
