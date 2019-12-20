package com.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2019/3/20 11:41
 * @desc: 采用java的列表，实现排序
 */
public class QuickSortByList {
    public static void sort(List<Integer> items){
        if (items.size() > 1){
            List<Integer> smaller = new ArrayList<Integer>(); // 存储小于被选项的一组
            List<Integer> same = new ArrayList<Integer>(); // 存储等于被选项的一组
            List<Integer> large = new ArrayList<Integer>(); // 存储大于被选项的一组

            Integer chosenItem = items.get(items.size() / 2); // 获取列表中间项的元素(被选项)
            // 进行对列表遍历，与被选项比较
            for (Integer i : items) {
                if (i < chosenItem)
                    smaller.add(i);
                else if (i > chosenItem)
                    large.add(i);
                else
                    same.add(i);
            }

            sort(smaller); // 递归调用排序方法
            sort(large);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(large);
        }
    }

    public static void main(String[] args) {
        List<Integer> items = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            items.add((int) (Math.random() * 10));
        }
        System.out.println("排序前列表：" + items);
        long startTime = System.currentTimeMillis();
        sort(items); // 进行排序
        long endTime = System.currentTimeMillis();
        System.out.println("所用时间为：" + (endTime - startTime) + "毫秒");
        System.out.println("排序后列表：" + items);

    }
}
