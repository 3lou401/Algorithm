package com.java.innerClass;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 13:37
 * Description:  内部类中总是持有外部类的引用，用于访问外部类的变量
 *
 */
public class Test1 {
    public static void main(String[] args) {
        Teacher t = new Teacher("zhangSan");
        t.useMethod(); //输出zhangsan
    }
}

class Teacher{
    String name;

    public void useMethod(){
//        Home home = new Home();
        Home home1 = this.new Home();
        home1.method();
    }

    public Teacher(String name) {
        this.name = name;
    }

    class Home{

        final static int a =10;

         int b = 20;

           void method2(){
            System.out.println("--");
        }
        public void method(){
            System.out.println(name);
        }
    }
}


