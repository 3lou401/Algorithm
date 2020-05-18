package com.java.collections.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/22
 * Time: 10:59
 * Description: 测试List接口的一些方法
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.subList(3,5).clear();
        list.forEach(System.out::print); //112567
    }
}
