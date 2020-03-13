package com.designModel.active.Immutable;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/3 9:51
 * @Desc:
 */
public class Test {
    public static void main(String[] args) {
        Test1 t1 = new Test1("zhangsan");
        System.out.println(t1.getName());

        Test2 t2 = new Test2("lisi");
        System.out.println(t2.getName());

//        Test1 t3 = t2;
//        System.out.println(t3.getName());
//        t2.name = "wangwu";
//        t3 = t2;
//        System.out.println(t3.getName());
    }
}

//弱不变模式缺点。子类不一定是不变的，可以通过子类修改父类的属性
 class Test1{
    private String name;

    public Test1(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
class Test2 extends Test1{
    public String name;

    public Test2(String name) {
        super(name);
    }
}
//class Test2 extends Test1{
//
//}