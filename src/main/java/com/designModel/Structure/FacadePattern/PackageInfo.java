package com.designModel.Structure.FacadePattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 22:56
 * @Desc: 外观模式 ： 存在多个子系统不利于客户端访问，
 *                  设计一个高层接口 ，聚合多个子系统对象，客户端访问这一借口
 *                  角色 ： 客户端 &  门面（外观） * 子系统
 */
public class PackageInfo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
class SubSystem1 {
    public void method1(){
        System.out.printf("子系统1的方法\n");
    }
}class SubSystem2 {
    public void method1(){
        System.out.printf("子系统2的方法\n");
    }
}class SubSystem3 {
    public void method1(){
        System.out.printf("子系统3的方法\n");
    }
}
// 门面角色
class Facade{
    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();

    //客户端实际访问的接口
    public  void method(){
        subSystem1.method1();
        subSystem2.method1();
        subSystem3.method1();
    }
}

