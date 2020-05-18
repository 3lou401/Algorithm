package com.concurrent.optimisticLock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/26
 * Time: 10:12
 * Description: 原子累加器
 */
public class Test7 {
    public static void main(String[] args) {
        //两个累加器
        demo(()->new AtomicLong(0),adder->adder.getAndIncrement());
        demo(()->new LongAdder(), adder->adder.increment());
    }

     private static <T> void demo(Supplier<T> supplier , Consumer<T> consumer){
         T adder = supplier.get();
         List<Thread> threads = new ArrayList<>();

         //4个线程，每个线程累积50 0000
         for (int i = 0; i < 4; i++) {
             threads.add(new Thread(() -> {
                 for (int j = 0; j < 500000; j++) {
                     consumer.accept(adder);
                 }
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
         System.out.println("cost : " + (end - start));
    }
}
