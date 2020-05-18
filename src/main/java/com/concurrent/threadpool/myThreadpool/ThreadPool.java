package com.concurrent.threadpool.myThreadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/27
 * Time: 21:01
 * Description: No Description
 */
@Slf4j(topic = "c.ThreadPool")
public class ThreadPool {
    private BlockingQueue<Runnable> taskqueue ;

    //线程集合
    private HashSet<Worker> workers = new HashSet<>();

    //核心线程数
    private int coreSize;
    //获得任务的超时时间
    private long timeout;
    //
    private TimeUnit timeUnit;

    public ThreadPool(int coreSize, long timeout,
                      TimeUnit timeUnit,int queueCapcity) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        taskqueue = new BlockingQueue<>(queueCapcity);
    }
    //任务交给线程执行
    public void execute(Runnable task){
        // 如果任务数没有超过核心数 表示还可以创建线程，继续执行
        //如果超过，就放到阻塞队列中暂时等待
        synchronized (workers){
           if ( workers.size() < coreSize ){
               log.debug("新建worker");
               Worker worker = new Worker(task);
               workers.add(worker);
               worker.start();
           }else{
              taskqueue.put(task);
           }
        }
    }

    class Worker extends  Thread{
        private Runnable task;

        public Worker(Runnable target) {
            this.task = target;
        }

        @Override
        public void run() {
            //如果task不为空，执行task
            //如果task为空，从任务队列中取出的不为空，执行任务
            while (task != null || (task = taskqueue.poll())!= null){
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                }

            }
            synchronized (workers){
                workers.remove(this);
            }
        }
    }
}
