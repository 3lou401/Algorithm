package com.concurrent.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/13
 * Time: 17:47
 * Description: 哲学家就餐示例
 */
public class Test2 {
    public static void main(String[] args) {
        //创建五根筷子和五个哲学家
        Chopsticks c1 = new Chopsticks("c1");
        Chopsticks c2 = new Chopsticks("c2");
        Chopsticks c3 = new Chopsticks("c3");
        Chopsticks c4 = new Chopsticks("c4");
        Chopsticks c5 = new Chopsticks("c5");

        Philosopher p1 = new Philosopher("柏拉图",c1,c2);
        Philosopher p2 = new Philosopher("阿基米德",c2,c3);
        Philosopher p3 = new Philosopher("老子",c3,c4);
        Philosopher p4 = new Philosopher("孔子",c4,c5);
        Philosopher p5 = new Philosopher("孙子",c1,c5);
//        Philosopher p5 = new Philosopher("孙子",c5,c1);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}

//筷子
class Chopsticks{
    private String name;

    public Chopsticks(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chopsticks{" +
                "name='" + name + '\'' +
                '}';
    }
}
//哲学家
@Slf4j(topic = "c.Philosopher")
class Philosopher extends Thread{

    private Chopsticks left,right;

    private String name;

    public Philosopher(String name,Chopsticks left, Chopsticks right) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (left) {
                synchronized (right) {
                    eating();
                }
            }
        }
    }

    private void eating() {
        try {
            Thread.sleep(1000);
            log.debug("eating");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
