package com.JVM.classloading;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/12
 * Time: 14:29
 * Description: Test Reflect
 */
public class Demo2 {
    public static void main(String[] args) {
        String className ="com.JVM.classloading.Demo2Bean";
        Demo2Bean demo2Bean = (Demo2Bean) loadClass(className);
    }
    private static Object loadClass( String className){
        try {
            Class instance = Class.forName(className);
            return instance.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
class Demo2Bean{
    static {
        System.out.println("Demo2Bean-init");
    }
}
