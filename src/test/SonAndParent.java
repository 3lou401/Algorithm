package test;

/**
 * @Author: leaderHoo
 * @Date: 2020/1/29 19:50
 * @Desc:
 */
public class SonAndParent {

}
class Parent{
    synchronized  void show(){
        System.out.printf("parent-show");
    }
    static  void say(){
        System.out.printf("par - say");
    }
}

class Son extends  Parent{
    // 子类方法，重写的时候，不会继承父类方法特征 （是否同步）
    void show(){
        System.out.printf("son-show");
    }
    //静态 不可以
//    void say(){
//
//    }
    void test2(){
        super.show();
    }

    public static void main(String[] args) {
        new  Son().test2();
    }
}