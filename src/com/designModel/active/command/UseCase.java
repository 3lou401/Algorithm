package com.designModel.active.command;


/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 18:07
 * @Desc: 客户点餐，服务员通过菜单通知厨师（不是直接喊，而是通过菜单，解耦服务员和厨师）
 * 时序图 ：客户 -服务员 --菜单 -- 厨师
 */
public class UseCase {
    public static void main(String[] args) {
        Order noodleO = new NoodleOrder(new NoodleChef());
        Waiter w = new Waiter();
        w.setNoodleOrder(noodleO);
        w.makeNoodle();
    }
}


//调用者， 调用做菜，真正做菜的是厨师 （执行者）
class Waiter{
    Order soupOrder, noodleOrder;

    public void setSoupOrder(Order soupOrder) {
        this.soupOrder = soupOrder;
    }

    public void setNoodleOrder(Order noodleOrder) {
        this.noodleOrder = noodleOrder;
    }
    public void makeSoup(){
        soupOrder.cooking();
    }
    public void makeNoodle(){
        noodleOrder.cooking();
    }
}

interface Order{
    void cooking();
}
class SoupOrder implements Order{
    private SoupChef soupChef;

    public void setSoupChef(SoupChef soupChef) {
        this.soupChef = soupChef;
    }

    public SoupOrder(SoupChef soupChef) {
        this.soupChef = soupChef;
    }

    @Override
    public void cooking() {
       soupChef.cooking();
    }
}
class NoodleOrder implements Order{
    private NoodleChef noodleChef;

    public void setNoodleChef(NoodleChef noodleChef) {
        this.noodleChef = noodleChef;
    }

    public NoodleOrder(NoodleChef noodleChef) {
        this.noodleChef = noodleChef;
    }

    @Override
    public void cooking() {
        noodleChef.cooking();
    }
}
//面条师傅
class NoodleChef{
    public void cooking() {
        System.out.printf("正在做面\n");
    }
}
// 汤点师傅
class SoupChef{
    public void cooking() {
        System.out.printf("正在做汤\n");
    }
}