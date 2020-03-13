package com.designModel.build.singletonPattern;

import java.util.HashMap;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/18 17:30
 * @Desc: 单例模式实现ID生成器 ,情形，无数据库，直接返回一个递增值
 *
 */
public class KeyGenerator {

    private static final KeyGenerator KEY_GENERATOR = new KeyGenerator();

    private  int key  = 1000;

    private KeyGenerator(){}

    public static KeyGenerator getKeyGenerator(){
        return KEY_GENERATOR;
    }

    public synchronized int getNextKey(){
        return key++;
    }
}

//下边测试用例：证明ID生成器可以向客户端提供键值
//缺点是没有数据存储功能，一旦重启，KeyGenerator会重新初始化，提供重复键值
class TestKeyGen{
    public static void main(String[] args) {
        KeyGenerator keyGenerator = KeyGenerator.getKeyGenerator();
        System.out.println("key--"+ keyGenerator.getNextKey());
        System.out.println("key--"+ keyGenerator.getNextKey());
        System.out.println("key--"+ keyGenerator.getNextKey());
        System.out.println("key--"+ keyGenerator.getNextKey());
    }
}


/**改进型一 ：连接数据库 **/
class KeyGenerator2 {
    private static final KeyGenerator2 instance = new KeyGenerator2();

    private KeyGenerator2(){}

    public  static KeyGenerator2 getInstance(){
        return instance;
    }
    public  synchronized int getNextKey(){
        return getNextKeyFromDB();
    }

    private int getNextKeyFromDB() {
        String sql1 = "update KeyTable set keyValue = keyValue + 1";
        String sql2 = "select keyValue from KeyTable";

        //省略 update和 select语句执行过程
        //....execute the update sql
        //...run the select sql, 类似 int key = execute(querySql);
        int key = 1000;
        return key;
    }
}

//方案三 ：键值的缓存方案 : 第一，针对多个表返回key , 第二， 持有一个池，有就从池中取，消费完了就再去数据那一个范围的key
//缺点是，如果重启时池中的id没有使用完，会被浪费掉
class keyGenerator3{
    private  static final keyGenerator3 instance = new keyGenerator3();

    private final int POOL_SIZE = 20;

    private HashMap keyList = new HashMap(10);

    private keyGenerator3(){}

    public static keyGenerator3 getInstance(){
        return instance;
    }

    public synchronized int getNextKey(String keyName){
        KeyInfo keyInfo;
        if (keyList.containsKey(keyName)){
            keyInfo = (KeyInfo) keyList.get(keyName);
            System.out.println("存在这个key");
        }else{
            keyInfo = new KeyInfo(POOL_SIZE,keyName);
            keyList.put(keyName,keyInfo);
            System.out.println("创建这个key");
        }
        return keyInfo.getNextKey();
    }
}
class KeyInfo{
    private int keyMax;
    private int keyMin;
    private int nextKey;
    private int poolSize;

    private String keyName;

    public KeyInfo(int poolSize, String keyName) {
        this.poolSize = poolSize;
        this.keyName = keyName;
    }

    public int getKeyMax() {
        return keyMax;
    }

    public int getKeyMin() {
        return keyMin;
    }

    public int getNextKey() {
        if (nextKey > getKeyMax()){
          return   retrieveFromDB();
        }
        return nextKey++;
    }

    private int retrieveFromDB() {
        String updateSql = "update KeyTable set keyValue = keyValue + "+ poolSize + " where keyName = "+keyName ;
        String querySql = "select keyValue from KeyTable where keyName = "+ keyName;
        // 在一个事务中执行上边的sql
//        int keyFromDB = baseDAO.executeQuery(querySql);
        int keyFromDB = 1000;

        keyMax = keyFromDB;
        keyMin = keyMax - poolSize +1;
        return keyMin;
    }
}

//方式五 ： 使用多例模式
class KeyGenerator5{
    private static HashMap keyGens = new HashMap(10);

    private final int pool_size = 20;
    private KeyInfo keyInfo;

    private KeyGenerator5(){}
    private KeyGenerator5(String name){
        keyInfo = new KeyInfo(pool_size,name);
    }

    public static KeyGenerator5 getKeyGens(String name){
        KeyGenerator5 keyGenerator5;
        if (keyGens.containsKey(name)){
            keyGenerator5 = (KeyGenerator5) keyGens.get(name);
        }else {
            keyGenerator5 = new KeyGenerator5(name);
            keyGens.put(name,keyGenerator5);
        }
        return keyGenerator5;
    }
    public synchronized  int getNextKey(){
        return keyInfo.getNextKey();
    }
}