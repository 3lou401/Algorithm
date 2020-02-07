package com.designModel.active.template;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 12:32
 * @Desc: 模板方法使用例子， 学生申请出国留学
 */
public class UseExample {
}

abstract class ApplyAbord{
    public void apply(){
        //1. 向国外对应学校申请
        applySchool();
        //2. 办理护照
        applyPassport();
        //3. 申请签证
        applyVisa();
        //4. 订机票
        applyTickets();
        //5. 去学校
        goAbord();
    }
    abstract void applySchool();
    public void applyPassport(){
        System.out.printf("1.准备材料\n");
        System.out.printf("2.办理护照\n");
    }
    abstract void applyVisa();
    abstract void applyTickets();
    abstract void goAbord();
}
class GoUS extends ApplyAbord{

    @Override
    void applySchool() {
        System.out.printf(" 向美国学校申请\n");
    }

    @Override
    void applyVisa() {
        System.out.printf(" 向美国驻华使馆申请申请\n");
    }

    @Override
    void applyTickets() {
        System.out.printf("订去美国机票\n");
    }

    @Override
    void goAbord() {
        System.out.printf("乘坐去美国飞机\n");
    }
}

class GoUK extends ApplyAbord{

    @Override
    void applySchool() {
        System.out.printf(" 向英国学校申请\n");
    }

    @Override
    void applyVisa() {
        System.out.printf(" 向英国驻华使馆申请\n");
    }

    @Override
    void applyTickets() {
        System.out.printf("订去英国机票\n");
    }

    @Override
    void goAbord() {
        System.out.printf("乘坐去英国飞机\n");
    }
}