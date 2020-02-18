package com.designModel.build.singletonPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/17 0:08
 * @Desc: 扩展多例模式 ： 一个类提供有限个实例, 饿汉式实现
 *  TODO 感觉用map存储会更合适，代码可能存在问题
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

