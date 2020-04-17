package com.concurrent.threadsafe.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/14
 * Time: 10:26
 * Description: 模拟两人相互转账多次
 * 示例输出1 ： 10:33:51.117 [main] c.TestTransfer -a money 1074
 *              10:33:51.119 [main] c.TestTransfer -b money 1005
 *            明显线程运行出问题
 *  解决 ： 寻找共享变量
 *          a.money 和 b.money
 *          所以 ，锁加在哪个对象很讲究 。 不能直接在 方法上 加synchronize
 */
@Slf4j(topic = "c.TestTransfer")
public class TestTransferAccount {

    static Random random = new Random();

    static int getRan(){
        return random.nextInt(5);
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);

        Thread t1 = new Thread(()->{
            for (int i=0;i<1000;i++){
                a.tranfer(b,getRan());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");
        t1.start();
        Thread t2 = new Thread(()->{
            for (int i=0;i<1000;i++){
                b.tranfer(a,getRan());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");
        t2.start();

        t1.join();
        t2.join();
        log.debug("a money {}",a.getMoney());
        log.debug("b money {}",b.getMoney());
    }
}
/*class Account{
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account(int money) {
        this.money = money;
    }
    public void tranfer(Account target, int num){
        if (getMoney() >= num){
            setMoney(getMoney() - num);
            target.setMoney(target.getMoney() + num);
        }
    }
}*/

//多个共享变量，如何加锁 ，直接在方法上加锁 ，测试是否可以
//测试发现是不可以的 ：
//原因 ：加在成员方法上，等价于 synchronize(this)
//10:39:21.171 [main] c.TestTransfer -a money 1013
// 10:39:21.174 [main] c.TestTransfer -b money 1093
/*class Account{
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account(int money) {
        this.money = money;
    }
    public synchronized void tranfer(Account target, int num){
        if (getMoney() >= num){
            setMoney(getMoney() - num);
            target.setMoney(target.getMoney() + num);
        }
    }
}*/

//多次测试发现结果是准确的
//10:40:59.871 [main] c.TestTransfer -a money 880
//10:40:59.875 [main] c.TestTransfer -b money 1120
class Account{
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account(int money) {
        this.money = money;
    }
    public  void tranfer(Account target, int num){
        synchronized(Account.class){
            if (getMoney() >= num){
                setMoney(getMoney() - num);
                target.setMoney(target.getMoney() + num);
            }
        }
    }
}
