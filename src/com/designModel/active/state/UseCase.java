package com.designModel.active.state;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/6 11:45
 * @Desc: 简单模拟一个线程生命周期
 * 状态模式重点在各状态之间的切换从而做不同的事情，而策略模式更侧重于根据具体情况选择策略，并不涉及切换。
 *
 * 状态模式不同状态下做的事情不同，而策略模式做的都是同一件事，例如聚合支付平台，有支付宝、微信支付、银联支付，虽然策略不同，
 *      但最终做的事情都是支付，也就是说他们之间是可替换的。反观状态模式，各个状态的同一方法做的是不同的事，不能互相替换
 *
 *  状态模式封装了对象的状态，而策略模式封装算法或策略。因为状态是跟对象密切相关的，它不能被重用；
 *      而通过从Context中分离出策略或算法，我们可以重用它们
 *
 *  在状态模式中，每个状态通过持有Context的引用，来实现状态转移；但是每个策略都不持有Context的引用，它们只是被Context使用
 */
public class UseCase {
    public static void main(String[] args) {
        //状态模式侧重状态转化
        ThreadState newState = new New();
        ContextUC contextUC = new ContextUC();
        contextUC.setState(newState);
        contextUC.start(); // 状态切换成Runable
        contextUC.getCPU();
        contextUC.stop();
    }
}

class ContextUC{
    private ThreadState state;

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    //下边是客户期望的方法
    public void start(){
        ((New) state).start(this);
    }

    public void getCPU(){
        ((Runnable)state).getCPU(this);
    }
    public void suspend(){
        ((Running)state).suspend(this);
    }
    public void stop(){
        ((Running)state).stop(this);
    }
    public void resume(){
        ((Blocked)state).resume(this);
    }

}
abstract class ThreadState{
    protected String stateName;
}

class New extends ThreadState{

    public New() {
        stateName = "新建状态";
        System.out.printf("当前状态是 ： 新建状态\n");
    }

    public void start(ContextUC contextUC){
        System.out.printf("当前状态是 ： 新建状态\n");
        if (stateName.equalsIgnoreCase("新建状态")){
            contextUC.setState(new Runnable()); //切换成Runnable
        }else{
            System.out.printf("当前状态不是新建状态\n");
        }
    }
}
class Runnable extends ThreadState{
    public Runnable() {
        stateName = "可运行";
        System.out.printf("当前状态是 ： 可运行\n");
    }
    public void getCPU(ContextUC contextUC){
        System.out.printf("当前状态是 ： 可运行\n");
        if (stateName.equalsIgnoreCase("可运行")){
            contextUC.setState(new Running()); //切换成Running
        }else{
            System.out.printf("当前状态不是可运行\n");
        }
    }
}
class Running extends ThreadState{
    public Running() {
        stateName = "运行中";
        System.out.printf("当前状态是 ： 运行中\n");
    }
    public void suspend(ContextUC contextUC){
        System.out.printf("当前状态是 ： 运行中\n");
        if (stateName.equalsIgnoreCase("运行中")){
            contextUC.setState(new Blocked()); //切换成 Blocked
        }else{
            System.out.printf("当前状态不是运行中\n");
        }
    }
    public void stop(ContextUC contextUC){
        System.out.printf("当前状态是 ： 运行中\n");
        if (stateName.equalsIgnoreCase("运行中")){
            contextUC.setState(new Stoped()); //切换成 Blocked
        }else{
            System.out.printf("当前状态不是运行中\n");
        }
    }
}
class Blocked extends ThreadState{
    public Blocked() {
        stateName = "阻塞中";
        System.out.printf("当前状态是 ： 阻塞中\n");
    }
    public void resume(ContextUC contextUC){
        System.out.printf("当前状态是 ： 阻塞中\n");
        if (stateName.equalsIgnoreCase("运行中")){
            contextUC.setState(new Running()); //切换成 Running
        }else{
            System.out.printf("当前状态不是运行中\n");
        }
    }
}class Stoped extends ThreadState{
    public Stoped() {
        stateName = "结束";
        System.out.printf("当前状态是 ： 结束\n");
    }
}