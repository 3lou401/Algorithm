package com.concurrent.designPattern.producerAndConsumer;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/3
 * Time: 14:44
 * Description: 测试生产者消费者
 */
@Slf4j(topic = "c.Test")
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue queue = new MessageQueue(2);
        for(int i= 0; i < 3;i++){
            int id = i;
            new Thread(()->{
                queue.put(new Message(id,"内容"+id));
            },"生产者"+id).start();
        }

        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = queue.get();
            }
        },"消费者").start();
    }
}
