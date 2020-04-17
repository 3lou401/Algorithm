package com.JDK8.old.methodReference;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/12
 * Time: 12:34
 * Description: No Description
 */
public class Demo2 {
    public static void main(String[] args) {
        Student s1 = new Student("lisi",12);
        Student s2 = new Student("wangwu",15);
        Student s3 = new Student("abc",12);
        Student s4 = new Student("tf",18);
        Student s5 = new Student("zh",11);

        List<Student> students = Arrays.asList(s1,s2,s3,s4,s5);
//        students.sort((stuParam1,stuParam2)->Student.compareByName(stuParam1,stuParam2));
//        students.forEach(student -> System.out.println(student.getName()));
//        System.out.println("-----");
        //相当于上边的语法糖  ， 类名 ：：静态方法
//        students.sort(Student :: compareByName);
//        students.forEach(student -> System.out.println(student.getName()));


        //第二种 实例 ：： 实例方法
        // lambda表达式
        StudentComparator studentComparator = new StudentComparator();
//        students.sort((stuParam1,stuParam2)->studentComparator.compareByAge(stuParam1,stuParam2));
//        students.forEach(student -> System.out.println(student.getAge()));

        //使用对象引用 :: 实例方法
//        students.sort(studentComparator::compareByAge);
//        students.forEach(student -> System.out.println(student.getAge()));


        // 第三种 ， 类名 ：： 实例方法
        students.sort(Student::compareAge);
        students.forEach(student -> System.out.println(student.getAge()));

    }
}
class Student{
    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static int compareByName(Student student, Student student2){
        return student.name.compareTo(student2.name)  ;
    }

    public static int compareByAge(Student s1, Student s2){
        return s1.getAge() - s2.getAge();
    }

    public int compareAge(Student s1){
        return  this.getAge() - s1.getAge();
    }
}

class StudentComparator{
    public  int compareByName(Student student, Student student2){
        return student.getName().compareTo(student2.getName())  ;
    }

    public  int compareByAge(Student s1, Student s2){
        return s1.getAge() - s2.getAge();
    }
}
