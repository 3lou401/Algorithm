package com.java.showInterface;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/5
 * Time: 16:12
 * Description: 接口的基本特性
 */
public class Test {
    public static void main(String[] args) {
        People people;
//        people = new People() ;  ERROR ,
        people = new Man();
        people.print();
    }

}
interface People{
    public static final int num = 10;
    int key = 12;

    public void add();


    default void print(){
        System.out.printf("num = "+ num);
        System.out.println("key = "+key);
    }
}

class Man implements People{

    @Override
    public void add() {
    }
}