package com.java.collections.listtest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/18
 * Time: 18:00
 * Description: 查看链表的信息
 * Java中链表都是双向的
 */
public class Test1 {
    public static void main(String[] args) {
        LinkedList<String> l1 = new LinkedList();
        l1.add("hello");
        l1.add("world");

        LinkedList<String> l2 = new LinkedList<>();
        l2.add("teacher");
        l2.add("student");

        //将l2 -> l1
        /*
            hello
            teacher
            world
            student
         */
        ListIterator<String> aLIter = l1.listIterator();
        Iterator<String> bIter = l2.iterator();
        while (bIter.hasNext()) {
            if (aLIter.hasNext())
                aLIter.next();
            aLIter.add(bIter.next());
        }
        l1.forEach(System.out::println);

    }
}
