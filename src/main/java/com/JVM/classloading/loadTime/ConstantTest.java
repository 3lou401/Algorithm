package com.JVM.classloading.loadTime;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/22
 * Time: 0:17
 * Description: 测试 final static是否触发类构造
 *      输出 ： hello
 *        没有打印Constant Class Init ，说明没执行初始化
 */
public class ConstantTest {
    public static void main(String[] args) {
        System.out.println(ConstantClass.hello);
    }
}
class ConstantClass{
    static {
        System.out.println("Constant class init");
    }
    protected static final String hello = "hello";
}
