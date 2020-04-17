package com.java.baseVal;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/29
 * Time: 22:55
 * Description: 一个java源文件中，可以定义多个java类
 */
public class Test8 {
    public static void main(String[] args) {
        Student s = new  Student("l",12);
//        LocalDate
    }
}
class Student{
    private  String name;
    private int age;

    public Student(String name1, int age) {
        this.name = name1;
        this.age = age;
    }
    public void say(String word){
        String speakword = this.name+" 说 ："+word;
        System.out.println(speakword);
    }

    public String getName() {
        return name;
    }
}


class A{
    private final  B b;

    public B getB() {
        return b;
    }

    A(B b) {
        this.b = b;
    }
}
class B{
    protected  int money;

    public B(int money) {
        this.money = money;
    }
}
class C {
    private int a;
    private static int b;
    static void show(){
//        System.out.println(a); // 静态域中不可访问实例域
    }
}
class TestB{
    public static void main(String[] args) {
        A a = new A(new B(12));
        System.out.println("现在是"+a.getB().money);
        a.getB().money =14;
        System.out.println("现在是"+a.getB().money); // 虽然B是final ，但是B自己的属性却可变
    }
}
