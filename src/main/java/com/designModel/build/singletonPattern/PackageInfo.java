package com.designModel.build.singletonPattern;

import java.io.Serializable;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/16 23:37
 * @Desc: 单例模式 ： 一个类只可以创建一个实例，并提供一个全局访问点访问该实例
 *              角色 ：单例类  & 使用者
 *              要求 ： 私有化构造函数 & 静态该类类型成员变量 & 静态方法返回该实例
 *              实现方式 饿汉式 ，JVM一加载类就实例化，优势不需要考虑多线程安全
 *                         懒汉式，调用时实例化，需要考虑多线程安全
 */
public class PackageInfo {
}
//饿汉式
class HungrySingletonClass{
    private static final  HungrySingletonClass instance
            =  new HungrySingletonClass();

    private HungrySingletonClass(){}

    public static HungrySingletonClass getInstance(){
        return instance;
    }
}

//懒汉式 ：需要考虑多线程问题
class LazySingletonClass{
    private static volatile LazySingletonClass instance = null;

    private LazySingletonClass(){}

    public static synchronized LazySingletonClass getInstance(){
        if (instance == null){
            instance = new LazySingletonClass();
        }
        return instance;
    }
}

// 懒汉式效率低下，双重验证锁的懒汉方式的方式

//为什么用双重验证, 模拟一下多线程操作

/**
 * 线程A getInstance , 没有实例， 加锁，进入同步代码块中
 * 此时 线程B getInstance 没有实例 ， 有锁，只能等待A释放锁
 * 线程A 在代码块中判断是否存在实例，没有创建完成 ，释放锁
 * 线程B 获得锁 ， 此时必须要在判断一次是否存在 ， 判断有实例，直接返回
 */

class DoubleCheckLazySingleton{
    private static volatile DoubleCheckLazySingleton instance = null;
    private DoubleCheckLazySingleton(){}
    public static DoubleCheckLazySingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckLazySingleton.class){
                if (instance == null){
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}



//使用枚举的取巧形式 ，解决反序列化 反射带来的破坏问题
enum SingletonEnum{
    INSTANCE ;

    private String name;

    //充当单例类的方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}