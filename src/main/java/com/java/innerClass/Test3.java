package com.java.innerClass;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/13
 * Time: 8:25
 * Description: 测试在 外部类中 new 内部类
 */
public class Test3 {
    public static void main(String[] args) {
        //在另一个类中初始化内部类，要求内部类必须是静态的
       Test3Outer.Test3StaticInnerClass test3SInner = new Test3Outer.Test3StaticInnerClass();
        //测试使用方法是否可以 : 发现可以通过方法返回的形式创建
        Test3Outer.Test3Inner test3Inner = new Test3Outer("zhangsan").creator2();
    }
}

class Test3Outer{
    class Test3Inner{
        private int age;

        public void show(){
            System.out.println("name-"+name+" age-"+age);
        }
    }

    public Test3Inner creator2(){
        return new Test3Inner();
    }

    private String name ;

    public Test3Outer(String name) {
        this.name = name;
    }
    public void creator(){
        Test3Inner test3Inner = new Test3Inner(); //在定义的类中可以直接初始化
    }
    static class Test3StaticInnerClass{


    }
}
