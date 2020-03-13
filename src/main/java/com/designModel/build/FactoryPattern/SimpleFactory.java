package com.designModel.build.FactoryPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/20 16:53
 * @Desc: 简单工厂模式 ： 没有了抽象工厂角色，只有具体工厂通过参数返回多个具体产品，
 *              也叫静态工厂模式
 */
public class SimpleFactory {
    public static void main(String[] args) {
        ProductSF psf1 = FactorySF.produce("sf1");
        psf1.show();
    }
}
class FactorySF{
    public static ProductSF produce(String productName){
        if (productName.equalsIgnoreCase("sf1")){
            return new ConcreteProSF1();
        }else {
            return new ConcreteProSF2();
        }
    }
}

interface ProductSF{
    void show();
}
class ConcreteProSF1 implements ProductSF{
    public void show(){
        System.out.printf("具体产品1\n");
    }
}

class ConcreteProSF2 implements ProductSF{
    public void show(){
        System.out.printf("具体产品2\n");
    }
}