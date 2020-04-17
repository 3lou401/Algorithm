package com.java.showenum;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/1
 * Time: 16:25
 * Description: No Description
 */
public enum SizeV3 {
    STUDENT(13,"李四",0.0),
    TEACHER(21,"王老师");
    private int age;
    private String name;
    private double salary;

    SizeV3(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    SizeV3(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
