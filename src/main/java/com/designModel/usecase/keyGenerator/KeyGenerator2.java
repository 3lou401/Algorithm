package com.designModel.usecase.keyGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 16:47
 * Description: 使用数据库的方式
 */
public class KeyGenerator2 {
    private static final  KeyGenerator2 instance
            = new KeyGenerator2();

    private int key;

    private  KeyGenerator2(){}

    public static KeyGenerator2 getInstance(){return instance;};

    public synchronized int getNextKey(){
        return getNextKeyFromDB();
    }

    private int getNextKeyFromDB() {

        return 0;
    }
}
