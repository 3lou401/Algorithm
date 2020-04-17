package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/29
 * Time: 23:42
 * Description: Java中方法是按值传递的
 */
public class Test10 {
    public void swap(int x, int y){
        int t = x;
        x = y;
        y = t;
    }

    public void swapStu(Student s1,Student s2){
        Student temp  = s1;
        s1 = s2;
        s2 = temp;
    }

    public static void main(String[] args) {
        Test10 test10 = new Test10();
        //测试 ：能否修改两个对象的指向
        Student zhangSan = new Student("张三",13);
        Student lisi = new Student("lisi",12);
        test10.swapStu(zhangSan,lisi);
        System.out.println("张三变否 "+zhangSan.getName()); //还是张三



        int a =3,b=4;
        test10.swap(a,b);
        System.out.println("after change  a, b "+a +" "+b); // 依然是 3 4 没有改变3 4的值
    }
}
class C1{
    private final int num = 1001;

    private final  String name;
    {
        name = "lisa";
    }

    public int age;

    public static void main(String[] args) {
        C1 c1 = new C1();
        System.out.println(c1.age); // 输出0
    }
}

class  C2{
    public static void main(String[] args) {
        C2 c2 = new C2();
    }
}
