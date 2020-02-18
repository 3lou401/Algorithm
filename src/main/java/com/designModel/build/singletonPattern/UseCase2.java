package com.designModel.build.singletonPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/16 23:58
 * @Desc: 饿汉式创建猪八戒
 */
public class UseCase2 {
}

class Bajie{
    private  static  final  Bajie  bajie = new Bajie();

    private Bajie(){}

    public static Bajie getBajie(){
        return bajie;
    }

}
