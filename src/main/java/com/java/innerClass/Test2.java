package com.java.innerClass;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/13
 * Time: 8:18
 * Description: 局部内部类  直接定义在方法内
 */
public class Test2 {
    public void start(){
        class MyInner implements Outer {

            @Override
            public String show() {
                return "inner";
            }
        }
        Outer outer = new MyInner();
        System.out.println(outer.show());
    }

    public static void main(String[] args) {
//        MyInner
    }
}
interface  Outer{
    String show();
}