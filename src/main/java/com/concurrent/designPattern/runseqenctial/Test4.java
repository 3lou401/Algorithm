package com.concurrent.designPattern.runseqenctial;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/16
 * Time: 21:11
 * Description: 测试交替输出
 */
public class Test4 {
    static Thread t1,t2,t3;
    public static void main(String[] args) {
        ParkUnPark parkUnPark = new ParkUnPark(5);

        t1 = new Thread(()->{
            parkUnPark.print("a",t2);
        },"t1");
        t2 = new Thread(()->{
            parkUnPark.print("b",t3);
        },"t2");
        t3 = new Thread(()->{
            parkUnPark.print("c",t1);
        },"t3");
        t1.start();
        t2.start();
        t3.start();
        //注意，一定要有
        LockSupport.unpark(t1);
    }

}
class ParkUnPark{
    private  int loopNum;

    public ParkUnPark(int loopNum) {
        this.loopNum = loopNum;
    }
    public void print(String str, Thread next){
        for (int i=0;i<loopNum;i++){
            LockSupport.park();
            System.out.printf(str);
            LockSupport.unpark(next);
        }

    }
}
