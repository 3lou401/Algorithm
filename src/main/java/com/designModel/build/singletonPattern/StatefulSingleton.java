package com.designModel.build.singletonPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/17 15:16
 * @Desc: 有状态的 单例模式
 */
public class StatefulSingleton {
    private  int  num;

    private StatefulSingleton(int num) {
        this.num = num;
    }

    private static volatile StatefulSingleton instance ;

    public static StatefulSingleton getInstance(int num){
        if (instance == null){
            synchronized (StatefulSingleton.class){
                if (instance == null){
                    instance = new StatefulSingleton(num);
                }
            }
        }
        return instance;
    }

}
class Test{
    public static void main(String[] args) {
        StatefulSingleton singleton1 = StatefulSingleton.getInstance(1);
        StatefulSingleton singleton2 = StatefulSingleton.getInstance(2);
        if (singleton1 == singleton2)
            System.out.println("相同的类");
        else
            System.out.println("不相同");
    }
}