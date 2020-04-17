package com.JDK8.Stream.baseinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 11:40
 * Description: 流，描述性语言。
 */
public class Test8 {
    static class Student{
        String name;
        int age;
        String addr;
    }

    public static void main(String[] args) {
        //有一个list<Student>
        List<Student> students = new ArrayList<>();
        students.stream().filter(student -> student.addr.equals("Beijing") && student.age>20)
                .sorted((stu1,stu2)-> stu1.age - stu2.age)
                .forEach(student -> System.out.println(student.name));

    }
}
