package com.concurrent.optimisticLock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/24
 * Time: 9:50
 * Description: 还是之前的例子
 */
public class Test2 {
    public static void main(String[] args) {
        DecimalAccount decimalAccount = new DecimalAccountNoCas(10000);
        DecimalAccount.demo(decimalAccount);
        DecimalAccount decimalAccount2 = new DecimalAccountCas(10000);
        DecimalAccount.demo(decimalAccount2);


    }
}

class DecimalAccountCas implements DecimalAccount{

    AtomicReference<BigDecimal> balance;

    public DecimalAccountCas(double bal) {
        this.balance = new AtomicReference<>(new BigDecimal(bal));
    }

    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true){
            BigDecimal prev = balance.get();
            BigDecimal next = prev.subtract(amount);
            if (balance.compareAndSet(prev,next)){
                break;
            }
        }
    }
}



class DecimalAccountNoCas implements DecimalAccount{

    BigDecimal balance;

    public DecimalAccountNoCas(double val) {
        this.balance = new BigDecimal(val);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
}

//bigdecimal类型账户
interface DecimalAccount {

    BigDecimal getBalance();

    void withdraw(BigDecimal amount);

    //启动1000个线程，每个线程-10，如果出事余额是10000，那应该最后结构是0
    static void demo(DecimalAccount account) {
        List<Thread> threads = new ArrayList<>();

        //1000个线程取
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> {
                account.withdraw(BigDecimal.TEN);
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
