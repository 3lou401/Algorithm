package com.designModel.build.BuilderPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/21 23:42
 * @Desc: 建造者模式 ： 侧重于零件组装
 *          角色 ： 导演者 & 抽象建造者 & 具体建造者 & 产品
 */
public class PackageInfo {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder1();
        Directer directer = new Directer(builder);
        Product product = directer.contruct();
        product.show();
    }
}
class Product{
    String partA;
    String partB;
    String partC;
    String partD;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void setPartD(String partD) {
        this.partD = partD;
    }

    public void show(){
        System.out.printf("我是产品\n");
    }
}

abstract class Builder{
    Product product = new Product();
    abstract void buildPartA();
    abstract void buildPartB();
    abstract void buildPartC();
    abstract void buildPartD();

    public Product getResult(){
        buildPartA();
        buildPartB();
        buildPartC();
        buildPartD();
        return product;
    }
}
class ConcreteBuilder1 extends Builder{
    @Override
    void buildPartA() {
        System.out.printf("正在生产PartA\n");
        product.setPartA("零件A");
    }
    @Override
    void buildPartB() {
        System.out.printf("正在生产PartB\n");
        product.setPartA("零件B");
    }
    @Override
    void buildPartC() {
        System.out.printf("正在生产PartC\n");
        product.setPartA("零件C");
    }
    @Override
    void buildPartD() {
        System.out.printf("正在生产PartD\n");
        product.setPartA("零件D");
    }
}

class Directer{
    Builder builder;

    public Directer(Builder builder) {
        this.builder = builder;
    }

    public Product contruct(){
        return builder.getResult();
    }
}


