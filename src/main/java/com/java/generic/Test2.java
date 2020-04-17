package com.java.generic;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/15
 * Time: 15:37
 * Description: 类型擦除，替换为限定类型（没有就是Object）
 */
public class Test2<T extends Comparable,U> {
    T first,second;

    public int compare(T t2){
        return this.compare(t2);
    }
}
