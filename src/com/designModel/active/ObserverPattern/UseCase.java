package com.designModel.active.ObserverPattern;

import java.util.*;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/7 0:26
 * @Desc:  学校打铃为例
 *      铃声分为上课、下课
 *     学生和老师听到铃声，
 */
public class UseCase {
    public static void main(String[] args) {
        Ring ring = new Ring();
        ring.add(new Teacher());
        ring.add(new Student()); //注册监听器
//        Observer
        ring.ring(false);
    }
}

// 铃声事件类 ：作为观察者接收到参数
class RingEvent extends EventObject{

    private boolean sound; //true上课；false下课

    public RingEvent(Object source,boolean sound) {
        super(source);
        this.sound = sound;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }
}

//主题
class Ring {
    private List<BellEventListener> listeners;

    public Ring() {
        this.listeners = new ArrayList<>();
    }
    public void add(BellEventListener bellEventListener){
        listeners.add(bellEventListener);
    }
    public void ring(boolean sound){
       String type =  sound ? "上课铃":"下课铃";
        System.out.printf(type+"响\n");
        RingEvent e = new RingEvent(this,sound);
        notifyAlLis(e);
    }
    private void notifyAlLis(RingEvent e){
        for (BellEventListener bl:
             listeners) {
            bl.handleBell(e);
        }
    }

}
interface  BellEventListener extends EventListener{
     void handleBell(RingEvent e);
}

class Teacher implements BellEventListener{

    @Override
    public void handleBell(RingEvent e) {
        if (e.isSound()){
            System.out.printf("老师 ： 上课了\n");
        }else{
            System.out.printf("老师 ： 下课了\n");
        }
    }
}
class Student implements BellEventListener{

    @Override
    public void handleBell(RingEvent e) {
        if (e.isSound()){
            System.out.printf("学生 ： 上课了\n");
        }else{
            System.out.printf("学生 ： 下课了\n");
        }
    }
}
