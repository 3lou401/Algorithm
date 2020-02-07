package com.designModel.active.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 20:21
 * @Desc: 宏命令 ： 组合模式 & 命令模式
 */
public class MacrosCommand {
    public static void main(String[] args) {
        //定义多个命令
        AbstractCommand  c1 = new ConcreteComandA(new Receiver("zhangSan"));
        AbstractCommand  c2 = new ConcreteComandA(new Receiver("lisi"));
        AbstractCommand  c3 = new ConcreteComandA(new Receiver("wangWu"));
        InvokerMacros invokerMacros  = new InvokerMacros();
        invokerMacros.add(c1);
        invokerMacros.add(c2);
        invokerMacros.add(c3);
        invokerMacros.execute();
    }
}

interface AbstractCommand{
    void execute();
}

// 具体命令
class ConcreteComandA implements AbstractCommand{
    private Receiver receiver;

    public ConcreteComandA(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute(){
        receiver.action();
    }
}

//接收者
class Receiver {
    private  String name;

    public Receiver(String name) {
        this.name = name;
    }

    public void action(){
        System.out.printf(name + "正在执行业务代码\n");
    }
}

// 修改调用者 ：
class InvokerMacros implements AbstractCommand{

    private List<AbstractCommand> commands = new ArrayList<>();

    public void add(AbstractCommand c){
        commands.add(c);
    }
    public void remove(AbstractCommand c){
        commands.remove(c);
    }

    @Override
    public void execute() {
        for (AbstractCommand command:
             commands) {
            command.execute();
        }
    }
}