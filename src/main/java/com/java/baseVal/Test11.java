package com.java.baseVal;

import java.*;
//import java.util.*;

import static  java.lang.System.*;
/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/30
 * Time: 22:18
 * Description: No Description
 */
public class Test11 {
    public static void main(String[] args) {
        out.println("import static 之后，可以直接使用out");
    }
}

class SuperC1{
    public void  show(){
        out.println("show-super");
    }
}
class SubC2 extends SuperC1{
    @Override
    public void show() {
//        SuperC1 ref = super;
//        ref.show();
        super.show();
    }
    public void showThis(){
        SubC2 ref = this;
        this.test();
    }
    public void test(){
        out.println("test-sub");
    }
}

class ParentD1{
    private String name;

    public ParentD1(String name) {
        this.name = name;
    }
}
class SonD2 extends ParentD1{
    private int anInt;
//    public SonD2( int anInt) {
//        this.anInt = anInt;
//    }

    public SonD2(String name, int anInt) {
        super(name);
        this.anInt = anInt;
    }

    public static void main(String[] args) {
        SonD2 d2 = null;
        ParentD1 d1 = new ParentD1("lisi");
//        d2 = d1;
    }
}

class SonD3 extends ParentD1{

    public SonD3(String name) {
        super(name);
    }

    public static void main(String[] args) {
        ParentD1 sd3 = new SonD3("第二种儿子");
//        SonD2 sonD2 = sd3;

        SonD2 [] sonD2s = new SonD2[10];
        ParentD1[] parentD1s = sonD2s;
//        parentD1s[0] = new SonD3("123");
    }
}