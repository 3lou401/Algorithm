package com.sortPackage;

/**
 * @Author: leaderHoo
 * @Date: 2019/12/30 19:15
 * @Desc:  总结
 *      1. 基数排序 ，时间复杂度最低，O(N+R), N是关键字的取值，R是每个关键字不同取值的个数
 *              是 分配型 排序， 参考扑克牌排序
 *      2. 其他排序都是基于 比较和交换， 时间复杂度基于比较的次数
 *      3. 简单排序、插入、冒泡， 都是O(N^2) , N很小时，推荐用
 *          关键字 简单排序 （min）, 插入排序（a[j] = a[j-1）, 冒泡（a[i] > a[i+1]）
 *      4. 希尔排序 是在插入排序的基础上，做的优化，利用一个增量序列grap ,时间复杂度O(N^d)
 *      5. 比较好的 快速排序 ， 归并排序， 堆排序， 大概都是O(NlogN)
 *          关键字，快排（pivot） , 归并（T[] temp）,堆排序（percdown）
 *
 *   应用：
 *      1. 谷歌热搜关键字， 第一次快排，之后，按照冒泡来（因为大部分有序了）
 */
public class Summarize {
}
