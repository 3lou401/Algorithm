package com.java.generic;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/14
 * Time: 17:37
 * Description: 泛型方法
 */
public class Test {
    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        //测试代码，不能推断时，还是要具体制定
        Long res = myBean.<Long,Integer>get(124);
        //多数情况下，会自动推断
        double b = myBean.get3(1.2);
        System.out.println(b);
    }
}

class MyBean{

    public <T,U> T get(U a){
        return (T) a; //只是为了测试
    }
    public <T,U> U get1(T a){
        return (U) a;
    }

    public <T> T get3(T a){
        return a;
    }
}