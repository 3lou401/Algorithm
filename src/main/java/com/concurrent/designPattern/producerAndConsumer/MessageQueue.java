package com.concurrent.designPattern.producerAndConsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/3
 * Time: 14:29
 * Description: No Description
 */
@Slf4j(topic = "c.MessageQueue")
public class MessageQueue {
    //用linkedlist模拟消息队列
    public LinkedList<Message> list = new LinkedList<>();
    private int capcity;
    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    public void put (Message message){
        synchronized (list){
            while (list.size() == capcity){
                try {
                    log.debug("队列已满，需要等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("添加消息 Message {}",message);
            list.addLast(message);
            list.notifyAll();
        }
    }
    public  Message get(){
        synchronized(list){
            while (list.isEmpty()){
                try {
                    log.debug("队列为空，需要等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            log.debug("获取消息 message {}",message);
            list.notifyAll();
            //错误代码，“IllegalMonitorStateException” 之前，不小心写成this.notifyAll()
            // 一定注意，wait和notify的一定是当前锁，不要一直this
            return message;
        }
    }
}
