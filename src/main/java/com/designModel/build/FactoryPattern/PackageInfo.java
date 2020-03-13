package com.designModel.build.FactoryPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/20 12:14
 * @Desc: 工厂模式创建对象 ：
 *          角色 ： 抽象产品角色 & 具体产品 & 抽象工厂角色 & 具体工厂角色
 *          特点 ： 具体产品与具体工厂角色一一对应
 *                  客户端使用时，都是针对抽象编程，只知道具体是哪个工厂即可， 不知道具体生产的是哪一个产品
 *
 */
public class PackageInfo {
    public static void main(String[] args) {
//        Factory factory = new ConcretePro1Fac();
//        Product product =   factory.produce();
//        product.zhiLeng();

        /**更常见 在工厂模式中，添加一个反射得到具体工厂的类**/
        String packageName ="com.designModel.build.FactoryPattern";
        String className = "ConcretePro1Fac";
        Factory factory = (Factory) ReadObject.getFactory(packageName+"."+className);
        Product product =   factory.produce();
        product.show();
    }
}
abstract  class Product{
    String name;
    abstract  void show();
}
class ConcreteProduct1 extends Product{
    public ConcreteProduct1() {
        super.name = "具体产品1";
    }

    @Override
    void show() {
        System.out.println(name + "--生产ing");
    }
}
class ConcreteProduct2 extends Product{
    public ConcreteProduct2() {
        super.name = "具体产品2";
    }
    @Override
    void show() {
        System.out.println(name + "--生产ing");
    }
}
interface Factory{
    Product produce();
}
class ConcretePro1Fac implements Factory{

    @Override
    public Product produce() {
        return new ConcreteProduct1();
    }
}
class ConcretePro2Fac implements Factory{

    @Override
    public Product produce() {
        return new ConcreteProduct2();
    }
}

//实际生产中，可能会用反射 + 参数得到具体的工厂类，而不是直接new 具体工厂
class ReadObject{
    static Object getFactory(String className){
        Object ret = null;
        try {
            Class<?> c = Class.forName(className);
            ret = c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}