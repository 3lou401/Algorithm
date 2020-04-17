package com.java.showReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/3
 * Time: 11:44
 * Description: 动态调用方法
 */
public class Test5 {
    static class MyBean {
        //没有参数方法 & 有参数方法
        public void printNonParam() {
            System.out.println("无参方法调用...");
        }

        public void printParam(String val, int num) {
            System.out.println("有参方法调用..." + val + " - " + num);
        }

        //实例方法 &静态方法
        public void printNonStatic() {
            System.out.println("实例方法调用...");
        }

        public static void printStatic() {
            System.out.println("静态方法调用...");
        }

        //返回值类型
        public int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        Class c = myBean.getClass();
        invokePublicMethod(c,"printNonParam",myBean,null);
        Object [] params = {"str",3};
        invokeAllTypeMethod(c,"printParam",myBean,params);
    }

    private static Object invokePublicMethod(Class c, String methodName, Object ref, Object... args) {
        Object res = null;
        Class[] paramType = {};
        if (args != null && args.length > 0){
            paramType = new Class[args.length];
            for (int i =0 ;i < args.length;i++){
                paramType[i] = args[i].getClass();
            }
        }
        try {
            Method method = c.getMethod(methodName,paramType);
            System.out.println("--");
            res = method.invoke(ref, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }
    private static Object invokeAllTypeMethod(Class c, String methodName, Object ref, Object... args) {
        Object res = null;
        Class[] paramType = {};
        if (args != null && args.length > 0){
            paramType = new Class[args.length];
            for (int i =0 ;i < args.length;i++){
                paramType[i] = args[i].getClass();
            }
        }
        try {
            Method method = c.getDeclaredMethod(methodName,paramType);
            System.out.println("---");
            method.setAccessible(true);
            res = method.invoke(ref, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

}
