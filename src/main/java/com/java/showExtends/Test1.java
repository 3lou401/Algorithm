package com.java.showExtends;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/16
 * Time: 17:07
 * Description: 父类和子类 javap只可以看到public属性
 */
public class Test1 {
}

class Parent{
    private int a;
    public String b= "par";
}
class Son extends Parent{

    //编译期会添加上 super()
    public Son() {
    }
}