package com.concurrent.synchronizedShow;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/18
 * Time: 14:59
 * Description: 打印偏向锁的头信息
 */
@Slf4j(topic = "c.TestBiased")
public class TestBiased {
    public static void main(String[] args) throws InterruptedException {

        //偏向锁有延迟，立刻打印，显示对象头 是 00 01
//        Dog d = new Dog();
//        log.debug( ClassLayout.parseInstance(d).toPrintable());
//
//        log.debug("------");
//        //等一段时间后，打印，对象头是01 01
//        Thread.sleep(5000);
//        Dog d1 = new Dog();
//        log.debug( ClassLayout.parseInstance(d1).toPrintable());

        //vm 参数 去掉延迟
        Dog dog = new Dog();
        ClassLayout classLayout = ClassLayout.parseInstance(dog);

       new Thread(()->{
           log.debug("synchronized前");
           System.out.println(classLayout.toPrintable());
           synchronized (dog){
               log.debug("synchronized中");
               System.out.println(classLayout.toPrintable());
           }
           log.debug("synchronized后");
           System.out.println(classLayout.toPrintable());
       },"t1").start();

       //可偏向对象，调用hashcode, 会禁用掉偏向状态

    }
}

class Dog {
}
