package com.concurrent.designPattern.guarded.ext2;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/2
 * Time: 11:22
 * Description: 解耦生产者和消费者
 */
@Slf4j(topic = "c.Test")
public class Test {

    static class GuardedObject{
        private int id;

        public GuardedObject(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        private  Object response;

        public synchronized Object get(long millis){
            long start = System.currentTimeMillis();
            long passed = 0;
            while (response == null){
                if (passed > millis){
                    break;
                }
                long needWait = millis - passed;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passed = System.currentTimeMillis() - start;
            }
            return response;
        }
        //重载版本，无时间限制
        public synchronized Object get(){
            while (response == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
        public  synchronized void complete(Object object){
            response = object;
            this.notifyAll();
        }
    }
    //用来存放多个guardedObject
    static class MailBoxes{
        private static Hashtable<Integer,GuardedObject> maps = new Hashtable<>();

        private static int id = 1;

        private static int generateId(){
            return id++;
        }

        public static GuardedObject createGO(){
            GuardedObject go = new GuardedObject(generateId());
            maps.put(go.getId(),go);
            return go;
        }
        public static Set<Integer> getIds(){
            return maps.keySet();
        }
        public static GuardedObject get(Integer id){
            return maps.get(id);
        }
    }

    static class People extends Thread{

        @Override
        public void run() {
            GuardedObject guardedObject = MailBoxes.createGO();
            log.debug("开始收信：id {}",guardedObject.getId());
            Object mail = guardedObject.get(5000);
            log.debug("收到信：id{},内容 {}",guardedObject.getId(),mail);
        }
    }
    static class PostMan extends Thread{
        private int num;
        private String mail;

        public PostMan(int num, String mail) {
            this.num = num;
            this.mail = mail;
        }

        @Override
        public void run() {
            GuardedObject guardedObject = MailBoxes.get(num);
            log.debug("送信使 : {} ， 内容是 :{}",num,mail);
            guardedObject.complete(mail);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //模拟过程 ：三个邮递员送信 ， 三个收信者收信
        for (int i= 1;i <= 3;i++){
            new People().start();
        }
        Thread.sleep(1000);
        //该模式 是送信的的收信的一一对应

        for (int id : MailBoxes.getIds()){
            new PostMan(id,"内容"+id).start();
        }

    }
}
