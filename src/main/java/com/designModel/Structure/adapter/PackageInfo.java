package com.designModel.Structure.adapter;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 13:12
 * @Desc: 适配器模式 ： 核心 ，编写一个适配器类作为 “目标接口”“系统目标接口”之间转换器
 *                      角色 ： 目标接口 - 适配器角色 - 适配者角色（目前系统存在的）
 *                      实现方式 ： 1、通过继承适配者类， 2、通过聚合适配者对象
 */
public class PackageInfo {
    public static void main(String[] args) {
//        Target target = new Adapter();
//        target.print();
        Target target = new Adapter2(new Adaptee());
        target.print();
    }
}

class Adaptee{
    public String business(){
        System.out.printf("这是系统目前存在的组件,功能是返回字符串...\n");
        return "hello";
    }
}
// 系统想要的功能,是打印功能
interface Target{
    public void print();
}
//适配器
class Adapter extends Adaptee implements Target{

    @Override
    public void print() {
        System.out.printf("适配器开始工作...\n");
        System.out.printf(""+super.business());
    }
}

//适配器第二种实现方式 ： 聚合对象
class Adapter2 implements Target{
    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void print() {
        System.out.printf("适配器开始工作...\n");
        System.out.printf(""+adaptee.business());
    }
}