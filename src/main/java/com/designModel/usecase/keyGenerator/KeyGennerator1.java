package com.designModel.usecase.keyGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 16:32
 * Description: 第一种方式 ：单例生成器 & 同步 getkey方法 & 持有成员变量
 * 缺点 ： 断点就会重新从1000开始生成
 */
public class KeyGennerator1 {
    private static final  KeyGennerator1 instance = new KeyGennerator1();

    private int key = 1000;

    private KeyGennerator1() {
    }
    public static KeyGennerator1 getInstance(){
        return instance;
    }
    public  synchronized int getNextKey(){
        return key++;
    }
}

