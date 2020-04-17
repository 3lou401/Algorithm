package com.java.innerClass;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/13
 * Time: 9:01
 * Description: 使用javap 查看一下内部类和外部类的class文件
 */
public class Test4 {
    int age;
    class Inner{
        String name;
        /*
            注意 使用外围类的属性时，age实际上是省略了Test4.this
         */
        public void show(){
//            System.out.println(Test4.this.age);
//            System.out.println(this.age); //Error
        }

        public void print(){
            System.out.println(age);
        }
    }
}
