package com.JVM.objectisdead;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 23:38
 * Description: 引用计数法，很那判断“对象之间相互引用”。
 * 这里测试Java是否使用引用计数法（当然是否）
 * vm args  -Xms50M -Xmx50M -verbose:gc  -XX:+PrintGCDetails
 */
public class Test {
    public Object instance;

    private  final byte[] zhanWeiByte ;

    public Test() {
        zhanWeiByte = new byte[2* 1024 *1024];
    }

    public static void main(String[] args) {
        Test objA = new Test();
        Test objB = new Test();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB=null;

        System.gc();

        SoftReference<String> sr = new SoftReference<>("abc");
        String str = sr.get();

        WeakReference<String> weakReference = new WeakReference<>("cde");
        String wStr = weakReference.get();
    }

}
