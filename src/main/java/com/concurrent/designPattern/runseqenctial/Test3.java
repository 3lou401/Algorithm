package com.concurrent.designPattern.runseqenctial;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/16
 * Time: 15:58
 * Description: 交替输出 abcabcabcabc
 *      ReentrantLock 多个waitset
 *      开始
 * abcabcabcabcabc
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        AwaitSignal as = new AwaitSignal(5);
        Condition aCon = as.newCondition();
        Condition bCon = as.newCondition();
        Condition cCon = as.newCondition();
        //执行a的
       new Thread(()->{
            as.print("a",aCon,bCon);
        },"t1").start();
         new Thread(()->{
            as.print("b",bCon,cCon);
        },"t2").start();
         new Thread(()->{
            as.print("c",cCon,aCon);
        },"t3").start();

        Thread.sleep(1000);
        as.lock();
        try {
            System.out.println("开始");
            aCon.signalAll();
        }finally {
            as.unlock();
        }
    }
}
class AwaitSignal extends ReentrantLock {
    private int loopNum;

    public AwaitSignal(int loopNum) {
        this.loopNum = loopNum;
    }
    public  void print(String str, Condition current ,Condition next){
       for (int i= 0;i<loopNum;i++){
           this.lock();
           try {
               current.await(); //获得current休息室锁
               System.out.printf(str);
               next.signalAll(); //唤醒下一个线程
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               this.unlock();
           }
       }
    }
}