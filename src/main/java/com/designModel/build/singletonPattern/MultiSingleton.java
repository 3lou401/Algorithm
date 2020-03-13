package com.designModel.build.singletonPattern;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/17 0:08
 * @Desc: 扩展多例模式 ： 一个类提供有限个实例, 饿汉式实现
 *  TODO 感觉用map存储会更合适
 */
public class MultiSingleton {

    private  static final List<MultiSingleton> lists = new ArrayList<>();

    private static int n = 10;

    private int key;

    static {
        for (int i = 0; i< n;i++){
            lists.add(new MultiSingleton(i));
        }
    }

    private MultiSingleton(int n){
        this.key = n;
    }

    public static MultiSingleton getInstance(){
        int index = (int) (Math.random() * n);
        return lists.get(index);
    }
}
class TestMul{
    public static void main(String[] args) {
        MultiSingleton multiSingleton1 = MultiSingleton.getInstance();
        MultiSingleton multiSingleton2 = MultiSingleton.getInstance();
        if (multiSingleton1 == multiSingleton2){
            System.out.println("是一个");
        }else {
            System.out.println("不是一个");
        }
    }
}
//先懒汉式实现 可以实现

class RefinedMultiSingleton{
    private  static HashMap<String,RefinedMultiSingleton> maps = new HashMap<>();

    private String key ; //状态

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private RefinedMultiSingleton() {
    }

    private RefinedMultiSingleton(String key) {
        this.key = key;
    }

    public  static RefinedMultiSingleton getInstance(String key){
        RefinedMultiSingleton instance = maps.get(key);
        if (instance == null){
            synchronized (RefinedMultiSingleton.class){
                if (instance == null){
                    instance = new RefinedMultiSingleton(key);
                    maps.put(key,instance);
                }
            }
        }
        return instance;
    }
    public  static RefinedMultiSingleton getInstance1(String key){
      if (maps.containsKey(key)){
          return maps.get(key);
      }else {
          RefinedMultiSingleton instance = new RefinedMultiSingleton(key);
          maps.put(key,instance);
          return instance;
      }
    }
}
class TestRefinedMulSingleton{
    public static void main(String[] args) {
        for (int i= 0; i< 2000;i++) {
            RefinedMultiSingleton refinedMultiSingleton = RefinedMultiSingleton.getInstance1("age");
            RefinedMultiSingleton refinedMultiSingleton1 = RefinedMultiSingleton.getInstance1("age");
            System.out.println("true Or false ? " + (refinedMultiSingleton == refinedMultiSingleton1));
        }

    }
}

