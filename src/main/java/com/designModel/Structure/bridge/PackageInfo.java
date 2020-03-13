package com.designModel.Structure.bridge;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 15:15
 * @Desc: 桥梁模式 ： 本质目的 ， 将一个类的抽象化和实现化分离
 *                    TODO 可以解决一个类存在多维度的子，比如图形可以按照颜色分，按照形状分
 *                 角色 ： 抽象化角色 & 扩展抽象化角色 & 实现化角色 & 具体实现化角色
 *                 结构 ： 抽象化角色中 聚合 实现化角色
 */
public class PackageInfo {
    public static void main(String[] args) {
        Implementor concreteA = new ConcreteImplA();
        Implementor concreteB = new ConcreteImplB();

        AbstractObj refinedObj = new RefinedObj(concreteA);
        refinedObj.oper();
        AbstractObj refinedObj1 = new RefinedObj(concreteB);
        refinedObj1.oper();

    }
}

interface Implementor{
    void  oper();
}
class ConcreteImplA implements Implementor{

    @Override
    public void oper() {
        System.out.printf("具体实现角色A...\n");
    }
}
class ConcreteImplB implements Implementor{

    @Override
    public void oper() {
        System.out.printf("具体实现角色B...\n");
    }
}

//抽象化角色
abstract class AbstractObj{
    protected Implementor impl;

    public AbstractObj(Implementor impl) {
        this.impl = impl;
    }
    abstract void oper();
}
//扩展实现类
class RefinedObj extends AbstractObj{
    public RefinedObj(Implementor impl) {
        super(impl);
    }

    @Override
    void oper() {
        System.out.printf("修订的抽象者角色....\n");
       impl.oper();
    }
}
class RefinedObj2 extends AbstractObj{
    public RefinedObj2(Implementor impl) {
        super(impl);
    }

    @Override
    void oper() {
        System.out.printf("修订的抽象者角色2....\n");
       impl.oper();
    }
}class RefinedObj3 extends AbstractObj{
    public RefinedObj3(Implementor impl) {
        super(impl);
    }

    @Override
    void oper() {
        System.out.printf("修订的抽象者角色3....\n");
       impl.oper();
    }
}