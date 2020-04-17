package com.java.generic;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/15
 * Time: 15:42
 * Description: 泛型导致多态问题
 */
public class Test3 {
    public static void main(String[] args) {
        Sub<String> stringSub = new Sub<>();
        System.out.println(stringSub.get("a"));
        System.out.println(stringSub.get(1));
    }
}
class Sup{
    public Object get(Object object){
        return object;
    }
}
class Sub<T extends String> extends Sup{
    public T get(T t){
        return t;
    }

    @Override
    public Object get(Object object) {
        return super.get(object);
    }
}