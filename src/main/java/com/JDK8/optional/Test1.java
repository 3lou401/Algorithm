package com.JDK8.optional;

import com.designModel.active.template.Test;

import java.util.*;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/5 9:54
 * @Desc:  optional 处理 NullPointException
 */
public class Test1 {
    public static void main(String[] args) {
//        Optional
    }
}

// 非空判断举例
class Address{
    String name;

    public Address(String name) {
        this.name = name;
    }

    public Address() {
    }
}
class Test1_1{
    //简单举例，jdk8之前的，非空判断
    public static void main(String[] args) {
        Address address = new Address();
        if (address != null){
            String name = address.name;
            if (name != null){
//                ...
            }
        }
    }
}

//使用Optional 判断是否为空和得到值
class Test1_2{
    public static void main(String[] args) {
//        Optional
        Optional<Address> optionalAddress = Optional.of(new Address("zhangSan"));
        if (optionalAddress.isPresent()){
            System.out.println(optionalAddress.get().name);
        }
        //上边的代码，不建议使用，推荐的是采用函数式编程，如下
        optionalAddress.ifPresent(address -> System.out.println(address.name));

        //如果没有值，打印一个默认值
        Optional<Address> oa2 = Optional.empty();
        System.out.println(oa2.orElse(new Address("lisi")).name);

        //如果没有值，得到一个默认值   orElseGet(supplier)
        // （supplier :调用一个无参，有一个返回值的方法，比如构造方法）
        Address obj = oa2.orElseGet(()->new Address("default"));
        System.out.println(obj.name);


    }
}

//使用optional 函数式编程的常用方法
class Test1_3{
    //一个老师带几个学生的模式

    public static void main(String[] args) {
       Student s1 = new Student("s1");
       Student s2 = new Student("s2");
       List<Student> list = Arrays.asList(s1,s2);

        Teacher teacher = new Teacher();
        teacher.setStudents(list);

        Optional<Teacher> optionalTeacher = Optional.ofNullable(teacher);
        //TODO 返回的是一个 List<Student> ,就是 theTe.students类型
       List<Student> students = optionalTeacher.map(theTe->theTe.students).orElse(Collections.emptyList());
        System.out.println(students);
    }


}
class Student{
    String name;
    public Student(String name) {
        this.name = name;
    }
    public Student() {
    }

    @Override
    public String toString() {
        return "{ name ："+ name +" }";
    }
}

class Teacher{
    List<Student> students ;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}