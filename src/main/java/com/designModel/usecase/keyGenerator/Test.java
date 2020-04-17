package com.designModel.usecase.keyGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/13
 * Time: 16:39
 * Description: No Description
 */
public class Test {
    public static void main(String[] args) {
        KeyGennerator1 kegen = KeyGennerator1.getInstance();
        for (int i=1; i < 5;i++){
           new Thread(()->{
               for (int l = 0; l< 100;l++){
                   System.out.println(Thread.currentThread().getName()+" - 使用键 ："+kegen.getNextKey());
               }
           },"Thread"+i).start();
        }
    }
}
