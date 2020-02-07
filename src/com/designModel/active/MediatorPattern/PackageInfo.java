package com.designModel.active.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/7 14:01
 * @Desc: 中介者模式
 */
public class PackageInfo {
    public static void main(String[] args) {
        Mediator mediator =  new ConcreteMediator();

        Collegue c1 = new Collegue1();
        Collegue c2 = new Collegue2();
        Collegue c3 = new Collegue3();

        mediator.register(c1);
        mediator.register(c2);
        mediator.register(c3);

        c1.send(); // 观察者模式是主题去主动通知 ； 中介者模式是同事对象去通知
    }
}
//1.抽象中介者 持有一个中介者列表
abstract class  Mediator{
    protected List<Collegue> collegues;

    public Mediator() {
        this.collegues = new ArrayList<>();
    }
    abstract void register(Collegue collegue);
    abstract void relay(Collegue collegue);
}

class ConcreteMediator extends  Mediator{

    @Override
    void register(Collegue collegue) {
        if (!collegues.contains(collegue)) {
            collegues.add(collegue);
            collegue.setMediator(this);
        }
    }

    @Override
    void relay(Collegue collegue) {
        //给其他对象发消息，排除自身
        for (Collegue c1:
             collegues) {
            if (!c1.equals(collegue)){
                c1.receive();
            }
        }
    }
}

// 3. 抽象同事类 持有中介者
abstract class Collegue{
    protected Mediator mediator;


    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void send();
    abstract void receive();
}
class Collegue1 extends Collegue{

    @Override
    void send() {
        System.out.printf("同事1通知别人\n");
        mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.printf("同事1收到消息\n");
    }
}
class Collegue2 extends Collegue{

    @Override
    void send() {
        System.out.printf("同事2通知别人\n");
        mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.printf("同事2收到消息\n");
    }
}
class Collegue3 extends Collegue{

    @Override
    void send() {
        System.out.printf("同事3通知别人\n");
        mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.printf("同事3收到消息\n");
    }
}
class Collegue4 extends Collegue{

    @Override
    void send() {
        System.out.printf("同事4通知别人\n");
        mediator.relay(this);
    }

    @Override
    void receive() {
        System.out.printf("同事4收到消息\n");
    }
}
