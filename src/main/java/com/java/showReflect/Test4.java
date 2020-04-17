package com.java.showReflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/3
 * Time: 11:10
 * Description: 获取Field的值
 */
public class Test4 {
    static class MyBean {
        private int age;
        public String name;
        private static int school;
        public static String town = "魏县";
        protected static int num = 2;

        static {
            school = 15;
        }

        {
            age = 14;
        }

        public MyBean(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException {
        MyBean myBean  = new MyBean(12,"lisi");
        Class c = MyBean.class;
//        printField(c,"town",null); // 输出 “魏县”
//        printField(c,"name",myBean); // lisi
        //修改无法看到 私有属性
        printAllField(c,"age",myBean);
        //protected属性,getField也看不到
        printAllField(c,"num",null);
    }
    //获取public属性的值
    private static void printField(Class c,String fieldName,Object ref)
            throws NoSuchFieldException, IllegalAccessException {
        Field f = c.getField(fieldName);
        Object res = f.get(ref);
        System.out.println(res);
    }
    //获取所有属性的值 (public protected private)
    private static void printAllField(Class c,String fieldName, Object ref)
            throws NoSuchFieldException, IllegalAccessException {
        //之前搞错了，使用getField ，报错“NoSuchFieldException”。
        // 忽视了getField看不到private属性
        Field f = c.getDeclaredField(fieldName);
        f.setAccessible(true);
        Object res = f.get(ref);
        System.out.println(res);
    }
}
