package com.concurrent.optimisticLock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/25
 * Time: 12:25
 * Description: No Description
 */
public class Test6 {
    public static void main(String[] args) {
        Student student = new Student();

        AtomicReferenceFieldUpdater updater =
                AtomicReferenceFieldUpdater.newUpdater(Student.class,String.class,"name");
        updater.compareAndSet(student,null,"zhangSan");
        System.out.println(student);
    }
}

class Student{
    volatile String name ;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}