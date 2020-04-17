package com.concurrent.designPattern.runseqenctial;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/16
 * Time: 15:29
 * Description: 测试线程的交替输出  abc abc abc abc
 * <p>
 * 考虑用一个int的标志
 * 第一次标记   打印完后下一次
 * a       1             2
 * b       2             3
 * c       3             1
 */
public class Test2 {
    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(1, 6);
        new Thread(() -> {
            wn.print(1, 2, "a");
        }).start();
        new Thread(() -> {
            wn.print(2, 3, "b");
        }).start();
        new Thread(() -> {
            wn.print(3, 1, "c");
        }).start();
    }
}

class WaitNotify {
    private int flag;
    private int loopNum;

    public WaitNotify(int flag, int loopNum) {
        this.flag = flag;
        this.loopNum = loopNum;
    }

    public void print(int temp, int nexFlag, String string) {
        for (int i = 0; i < loopNum; i++) {
            synchronized (this) {
                while (temp != this.flag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf(string);
                this.flag = nexFlag;
                this.notifyAll();
            }
        }
    }
}