package com.designModel.active.state;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/5 13:19
 * @Desc:  状态模式 抽象状态 &具体状态 & 环境类
 * 和策略模式区别 ： 状态模式中，环境类中状态在一个生命周期可能经常改变，
 * 策略模式中，环境类中状态在一个生命周期可能只有一个
 */
public class PackageInfo {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteState1());
        context.action();
        context.setState(new ConcreteState2());
        context.action();
    }
}
abstract class  State{
    abstract void sampleOper();
}
class  ConcreteState1 extends  State{

    @Override
    void sampleOper() {
        System.out.printf("当前状态是1\n");
    }
}class  ConcreteState2 extends  State{

    @Override
    void sampleOper() {
        System.out.printf("当前状态是2\n");
    }
}
class Context{
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void action(){
        state.sampleOper();
    }
}