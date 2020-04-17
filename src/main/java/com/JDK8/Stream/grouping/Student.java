package com.JDK8.Stream.grouping;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/11
 * Time: 12:54
 * Description: No Description
 */
public class Student {
    private String name;
    private int score;
    private String addr;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, String addr) {
        this.name = name;
        this.score = score;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
