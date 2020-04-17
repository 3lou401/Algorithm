package com.concurrent.threadsafe.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 18:06
 * Description: 练习题 ： 模拟多人在一个床口买票 。
 * 如果卖出的票和剩下的票之和等于 初始票数，就是线程安全的
 * 线程安全问题 很明显
 *  加了同步锁之后，解决了问题
 *  TODO 发现另外一个情况，比如总票数 10000  5000个线程 。 发现最终卖出的 剩下的票远远多于起始的10000
 *  按说不应该
 *
 */
@Slf4j(topic = "c.ExerciseSellTicket")
public class ExerciseSellTicket {

    static Random random = new Random();

    private static int getRandomInt() {
        return random.nextInt(5) + 1;
    }

    public static void main(String[] args) {

        //只有一个窗口
        TicketWindow ticketWindow = new TicketWindow(1000);

        //多个线程模拟多个人
        List<Thread> threadList = new ArrayList<>();

        List<Integer> sellList = new Vector<>(); //统计已经买过的人，每个人买的票

        for (int i = 0; i < 400; i++) {
            Thread thread = new Thread(() -> {
                int byNum = getRandomInt();
                sellList.add(ticketWindow.sell(byNum));
                //买完票，就休息一下，让线程可以切换
                try {
                    Thread.sleep(getRandomInt() *200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            threadList.add(thread);//只会被主线程使用，所以不会出现竞争
            thread.start();
        }

        //等待买票结束
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        //打印一下，当前剩余票数和当前已卖票数
        log.debug("卖出的票 {}", sellList.stream()
                .mapToInt(Integer::intValue).sum());
        log.debug("剩余的票 {}", ticketWindow.getTicketNum());

    }


}

class TicketWindow {
    private int ticketNum;

    public TicketWindow(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public synchronized int sell(int count) {
        if (this.ticketNum  >= ticketNum) {
            ticketNum -= count;
            return count;
        } else {
            return 0;
        }
    }
}
