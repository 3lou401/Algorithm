package com.JVM.GarbageCollection;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/19 19:11
 * @Desc: 看一下， hotspot中是否用 引用计数器判断一个对象是否已经失效
 */
public class TestReferenceUseCondition {
    public static void main(String[] args) {
        DemoBean db1 = new DemoBean();
        DemoBean db2 = new DemoBean();

        db1.instance = db2;
        db2.instance = db1; // 相互引用

        //将栈上引用置空，测试是否发生回收，
        // 因此此时db1 db2 引用计数均为1 ，不会回收，如果回收，说明回收期没有采用引用计数器
        db1 = null;
        db2 = null;
    }
}

class DemoBean{
     DemoBean instance ; // 测试相互引用

    public DemoBean() {
        byte[] datas = new byte[20 * 1024 * 1024]; // 1024 byte = 1 KB  1024 KB = 1 M
    }
}