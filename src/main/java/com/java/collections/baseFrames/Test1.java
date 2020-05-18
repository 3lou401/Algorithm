package com.java.collections.baseFrames;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/17
 * Time: 14:57
 * Description: Java的集合框架 - 迭代器使用
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("c","b","hello","你好"); //使用这个测试无法通过，使用下边的可以

//        List<String> list = new ArrayList<String>();
//        list.add("abc");
//        list.add("bbc");
//        list.add("cbc");

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()) {
            String str = iterator.next();//读取当前集合数据元素
            if ("b".equals(str)) {
                //all.remove(str);//使用集合当中的remove方法对当前迭代器当中的数据元素值进行删除操作
                // (注:此操作将会破坏整个迭代器结构)使得迭代器在接下来将不会起作用
                iterator.remove();
            } else {
                System.out.println(str + " ");
            }
        }
        System.out.println(list.size());
    }
}
class  Test2{
    public static void main(String[] args) throws UnsupportedEncodingException {
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("bbc");
        list.add("cbc");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
            if(str.equals("abc")){
                it.remove();
            }
        }

        System.out.println(list.size());
    }
}