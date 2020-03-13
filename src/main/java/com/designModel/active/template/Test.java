package com.designModel.active.template;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/6 11:59
 * @Desc:  重构大的代码块
 */
public class Test {
    public void bigMethod(){
        int age = 13;
        if (age < 10){
            System.out.println("小孩子");
        }else if (age < 20){
            System.out.println("少年");
        }else if (age < 30){
            System.out.println("成年人");
        }else{
            System.out.println("壮年");
        }
    }
}
abstract class Test2{
    public void bigMethod(){
        int age = getAge();
        print(age); //多态代替if-else
    }
    public  int getAge(){
        return 13;
    }
    public  abstract void print(int age);
}
//多态，多个具体的策略
class Baby extends Test2{
    @Override
    public void print(int age) {
        System.out.println("小孩子");
    }
}
class Teenager extends  Test2{
    @Override
    public void print(int age) {
        System.out.println("少年");
    }
}
