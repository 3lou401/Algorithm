package com.JVM.outOfMemoryShow;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 22:41
 * Description: 测试虚拟机栈溢出
 * VM args : -Xss128k
 */
public class Test2 {
    private int stackLength = 0;
    public  void invoke(){
        stackLength++;
        invoke();
    }
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        try {
            test2.invoke();
        } catch (Throwable e) {
            System.out.println("stack " + test2.stackLength);
            throw e;
        }
    }
}
