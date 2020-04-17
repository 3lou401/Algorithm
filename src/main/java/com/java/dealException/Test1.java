package com.java.dealException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/13
 * Time: 15:52
 * Description: Java中异常处理机制
 *         异常 ： Error
 *                Exception
 *                          RuntimeException
 *                           其他异常      ---- 只有此类异常是 “受检查异常”
 *
 *          处理
 *                  声明异常 : 方法允许 声明受检查异常 ,建议是
 */
public class Test1 {

    public void method1 () throws FileNotFoundException{

    }
    public void method2() throws  ArrayIndexOutOfBoundsException{

    }
}

class Parent{
    public void play() throws IOException{}
}
class Sub extends Parent{

    //子类重写父类方法，只可以抛出比父类更具体的异常或者不抛出异常
    /*@Override
    public void play() throws FileNotFoundException {
    }*/
//    @Override
//    public void play() throws Exception {
//    }

}
