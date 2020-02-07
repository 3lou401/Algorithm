package com.designModel.Structure.bridge;

/**
 * @Author: leaderHoo
 * @Date: 2020/1/17 10:19
 * @Desc:
 */
public abstract class Abstraction {
    protected  Implementor impl;

    public  void  operation(){
        impl.oper();
    }
}
