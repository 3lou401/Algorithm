package com.designModel.active.command;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 17:09
 * @Desc: 命令模式  这是一种设计方式 ： 将接收者聚合到具体命令中 （两个接受这没有共同父亲）；
 * 也可以在抽象命令中聚合一个父亲（接收者A & 接收者B）
 */
public class packageinfo {
    public static void main(String[] args) {
        Command ca = new ConcreteComA(new ReceiverA());

        Invoker invoker = new Invoker();
        invoker.setcA(ca);

        invoker.actionA();
    }
}

//1. 请求者
class Invoker{
    private  Command cA ,cB;

    public void setcA(Command cA) {
        this.cA = cA;
    }

    public void setcB(Command cB) {
        this.cB = cB;
    }
    public void actionA(){
        cA.execute();
    }
    public void actionB(){
        cB.execute();
    }
}

//抽象命令
interface  Command{
    void execute();
}
// 具体命令
class ConcreteComA implements Command{
    private  ReceiverA receiver;

    public ConcreteComA(ReceiverA receiver) {
        this.receiver = receiver;
    }

    public void execute(){
        receiver.action();
    }
}
class ConcreteComB implements Command{
    private  ReceiverB receiver;

    public ConcreteComB(ReceiverB receiver) {
        this.receiver = receiver;
    }

    public void execute(){
        receiver.action();
    }
}

// 执行者 或叫 接收者
class ReceiverA{
    public void action(){
        System.out.printf("执行者A正在执行命令\n");
    }

}

class ReceiverB{
 public void action(){
     System.out.printf("执行者B正在执行命令\n");
 }
}
