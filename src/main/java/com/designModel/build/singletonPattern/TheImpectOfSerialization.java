package com.designModel.build.singletonPattern;

import java.io.*;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/17 13:28
 * @Desc: 测试序列化对单例模式的影响
 */
public class TheImpectOfSerialization {
}

// 先来个双重验证的懒汉模式
class Singleton1  implements Serializable{
    private static volatile  Singleton1 instance = null;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if (instance == null){
            synchronized (Singleton1.class){
                if (instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}

class TestSingleton1{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //先测试单例模式
         Singleton1 sInstance1 = Singleton1.getInstance();
         Singleton1 sInstance2 = Singleton1.getInstance();
         if (sInstance1 == sInstance2)
             System.out.println("它们是一个东西");
         else
             System.out.println("它们不是一个东西");
        // 在测试序列化反序列化之后效果
        System.out.println("-----测试序列化反序列化后结果----");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp"));
        oos.writeObject(sInstance1);
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(new File("temp")));
        Singleton1 newInstance = (Singleton1) ois.readObject();
        if (sInstance1 == newInstance)
            System.out.println("反序列化回来，依然还是单例");
        else
            System.out.println("证明了 反序列化对 单例模式存在影响");
    }
}
//原因 序列化会通过反射调用无参数的构造方法创建一个新的对象

// 解决反序列化的破坏性 只要在Singleton类中定义readResolve就可以解决该问题
class RefinedSingleton1 implements Serializable{

    private static volatile  RefinedSingleton1 instance = null;

    private RefinedSingleton1(){}

    public static RefinedSingleton1 getInstance(){
        if (instance == null){
            synchronized (RefinedSingleton1.class){
                if (instance == null){
                    instance = new RefinedSingleton1();
                }
            }
        }
        return instance;
    }
    private Object readResolve() {
        return instance;
    }
}

class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RefinedSingleton1 sInstance1 = RefinedSingleton1.getInstance();
        System.out.println("-----测试修改后结果----");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp"));
        oos.writeObject(sInstance1);
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(new File("temp")));
        RefinedSingleton1 newInstance = (RefinedSingleton1) ois.readObject();
        if (sInstance1 == newInstance) {
            System.out.println("反序列化回来，依然还是单例");
            System.out.println("证明了Object readResolve()可以解决问题");
        }
        else{
            System.out.println("没有效果");
        }
    }
}