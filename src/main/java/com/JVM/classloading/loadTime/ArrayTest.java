package com.JVM.classloading.loadTime;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/22
 * Time: 0:13
 * Description: 测试通过数组，是否触发类构造器
 *      结果，不打印任何消息，换句话说，只是定义数组不会触发 类构造
 */
public class ArrayTest {
    public static void main(String[] args) {
        SuperClass[] superClasses = new SuperClass[20];
    }
}
