package com.designModel.build.singletonPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/16 23:45
 * @Desc: 单例模式例子 ：比如说总统， 肯定是单例的，这里采用懒汉式创建
 * TODO 多线程条件下，测试懒汉模式创建单例
 */
public class UseCase {
    public static void main(String[] args) {

        President bushi = President.getPresident();
        President xiaobushi = President.getPresident();
        if (bushi == xiaobushi){
            System.out.println("这是一个总统");
        }else {
            System.out.println("这不是一个总统");

        }
    }
}

class President{


    public void getName() {
        System.out.println("我是特朗普");
    }

    private static volatile President president = null;

    private President(){
        System.out.println("产生一个总统");
    }

    public static synchronized President getPresident(){
        if (president == null){
            president = new President();
        }else {
            System.out.printf("总统已经有了\n");
        }
        return president;
    }
}