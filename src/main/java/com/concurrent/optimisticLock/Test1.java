package com.concurrent.optimisticLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/23
 * Time: 16:49
 * Description: 引入乐观锁
 */
public class Test1 {
    public static void main(String[] args) {
        Account account = new UnSafeAccount(10000);
        Account.demo(account); // 不安全每次输出不一样
        Account account1 = new SynchronizedAccount(10000);
        Account.demo(account1);
        /*
        余额 ： 10
        cost : 87
        余额 ： 0
        cost : 77
         */
        Account account2 = new AccountCas(10000);
        Account.demo(account2);
        /*
        余额 ： 0
        cost : 58
         */
    }
}

//实现类
class UnSafeAccount implements Account {
    private int amount;

    public UnSafeAccount(int amount) {
        this.amount = amount;
    }

    @Override
    public Integer getBalance() {
        return amount;
    }

    @Override
    public void withdraw(Integer amount) {
        this.amount -= amount;
    }
}


class SynchronizedAccount implements Account {
    private int amount;

    public SynchronizedAccount(int amount) {
        this.amount = amount;
    }

    @Override
    public Integer getBalance() {
        return amount;
    }

    @Override
    public void withdraw(Integer amount) {
        synchronized (this) {
            this.amount -= amount;
        }

    }
}

class AccountCas implements Account {
    private AtomicInteger balance;

    public AccountCas(int bal) {
        this.balance = new AtomicInteger(bal);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
//        while (true) {
//            int prev = balance.get();
//            int next = prev - amount;
//            if (balance.compareAndSet(prev, next)) {
//                break;
//            }
//        }
        //方式二 下边一行等价于上边的while循环
//        balance.getAndUpdate(prev -> prev - amount);
//        方式三
        balance.getAndAdd(-1 * amount);

    }
}

interface Account {
    Integer getBalance();

    void withdraw(Integer amount);

    //启动1000个线程，每个线程-10，如果出事余额是10000，那应该最后结构是0
    static void demo(Account account) {
        List<Thread> threads = new ArrayList<>();

        //1000个线程取
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }

        long start = System.currentTimeMillis();

        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("余额 ： " + account.getBalance());
        System.out.println("cost : " + (end - start));
    }

}
