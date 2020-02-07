package com.designModel.active.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/7 0:07
 * @Desc:
 */
public class PackageInfo {
    public static void main(String[] args) {
        Observers ob1 = new Observer1();
        Observers ob2 = new Observer2();
        Observers ob3= new Observer3();
        Observers ob4 = new Observer4();

        //把1 2 3 填进去
        Subject subject = new ConcreteSubject();
        subject.add(ob1);
        subject.add(ob2);
        subject.add(ob3);
        subject.remove(ob2);

        subject.notifyAllObservers();
    }
}

abstract class Subject{
    List<Observers> list = new ArrayList<>();

    public void add(Observers observers){
        list.add(observers);
    }
    public void remove(Observers observers){
        list.remove(observers);
    }
    public  abstract  void notifyAllObservers();

}

class ConcreteSubject extends Subject{

    @Override
    public void notifyAllObservers() {
        System.out.printf("当状态改变时\n");
        System.out.printf("\n");
        for (Observers ob:
             list) {
            ob.update();
        }
    }
}

interface Observers{
    void update();
}
class Observer1 implements Observers{

    @Override
    public void update() {
        System.out.printf("我是第一个观察者，我要改变\n");
    }
}class Observer2 implements Observers{

    @Override
    public void update() {
        System.out.printf("我是第二个观察者，我要改变\n");
    }
}class Observer3 implements Observers{

    @Override
    public void update() {
        System.out.printf("我是第三个观察者，我要改变\n");
    }
}class Observer4 implements Observers{

    @Override
    public void update() {
        System.out.printf("我是第四个观察者，我要改变\n");
    }
}