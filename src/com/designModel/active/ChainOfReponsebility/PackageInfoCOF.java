package com.designModel.active.ChainOfReponsebility;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/5 10:39
 * @Desc: 责任链模式
 */
public class PackageInfoCOF {
}

// 抽象责任链
abstract class AbstractHandler{
    private  AbstractHandler next;

    public AbstractHandler getNext() {
        return next;
    }

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    abstract void handleRequest(String s);
}

class ConcreteHandlerA extends AbstractHandler{

    @Override
    void handleRequest(String s) {
        System.out.printf("我是A  ");
        if (s.equalsIgnoreCase("A")){
            System.out.printf("这是我的职责\n");
        }else {
            if (getNext() == null){
                System.out.printf("没人处理\n");
            }else {
                System.out.printf("不归我管，交给下家\n");
                super.getNext().handleRequest(s);
            }
        }
    }
}
class ConcreteHandlerB extends AbstractHandler{

    @Override
    void handleRequest(String s) {
        System.out.printf("我是B  ");

        if (s.equalsIgnoreCase("B")){
            System.out.printf("这是我的职责\n");
        }else {
            if (getNext() == null){
                System.out.printf("没人处理\n");
            }else {
                System.out.printf("不归我管，交给下家\n");
                super.getNext().handleRequest(s);
            }
        }
    }
}

class ClientCOF{
    public static void main(String[] args) {
        AbstractHandler a1 = new ConcreteHandlerA();
        AbstractHandler a2 = new ConcreteHandlerB();
        a1.setNext(a2);
        a1.handleRequest("B");
    }
}
