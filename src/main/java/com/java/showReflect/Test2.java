package com.java.showReflect;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/2
 * Time: 21:12
 * Description: 获取Class类对象的三种方式 ： obj.getClass()  、类名.class 、静态方法Class.forName
 */
public class Test2 {
    static class MyBean{

    }
    public static void main(String[] args) throws ClassNotFoundException {

        MyBean myBean = new MyBean();
        //1、使用obj.getClass()
        Class myBeanClass = myBean.getClass();
        System.out.println(myBeanClass.getName());
        //我想作死，看一下Class类对象 有没有 Class
//        System.out.println(myBeanClass.getClass().getName());

        //2.使用类型.class
        System.out.println(int[].class);  //class [I

        //3. 如果是接口或者是类，可以使用Class.forName
//        System.out.println(Class.forName("int").getName()); // 会抛出异常 ClassNotFoundException
        System.out.println(Class.forName("com.java.showReflect.Test2").getName());//可以正常得到结果
        //TODO 小问题就是，如果要拿的Test2的内部类，forName是不可行的，必须用之前的两种方式

    }
}
