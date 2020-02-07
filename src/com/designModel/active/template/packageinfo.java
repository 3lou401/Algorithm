package com.designModel.active.template;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 12:22
 * @Desc: 模板方法模式 ： 定义一个算法的骨架，具体细节延时到子类去实现
 */
public class packageinfo {
    public static void main(String[] args) {
        TemplateParent example = new Concrete();
        example.templateMethod();
    }
}

abstract  class  TemplateParent{
    public void templateMethod(){
        concreteM1();
        oper1();
        oper2();
    }
    public void concreteM1(){
        System.out.printf("这是父类具体方法\n");
    }
    abstract void oper1();
    abstract void oper2();
}

class Concrete extends TemplateParent{

    @Override
    void oper1() {
        System.out.printf("子类事先具体算法1");
    }

    @Override
    void oper2() {
        System.out.printf("子类事先具体算法2");
    }
}