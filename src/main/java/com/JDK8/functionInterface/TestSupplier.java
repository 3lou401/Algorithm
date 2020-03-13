package com.JDK8.functionInterface;

import java.util.function.Supplier;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/1 14:37
 * @Desc:
 */
public class TestSupplier {
    public static void main(String[] args) {
//        Supplier :  每次调用都会返回一个新的或者不同的对象
        Supplier<Student> s = ()->new Student();
        Student student = s.get();
        System.out.println(student.name);

    }
}
class Student{
     String name="zhangSan";
}
