package com.designModel.Structure.bridge;

import javax.sql.rowset.spi.SyncResolver;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 16:12
 * @Desc: 包 分为颜色和类型
 *      比如红色钱包 ，按照旧的代码设计，会设计成钱包的子类，这里直接用聚合方式
 *      让钱包聚合实现（颜色）
 *
 */
public class UseCase {
    public static void main(String[] args) {
        Color red = new Red();
        Brand lv = new Lv();
        Bag bag = new Wallet(red,lv);
        System.out.printf("这是个"+bag.getName());
    }
}

// 实现角色 和 具体实现角色
interface Color{
    String getColor();
}
class Red implements Color{

    @Override
    public String getColor() {
        return "红色";
    }
}class Blue implements Color{

    @Override
    public String getColor() {
        return "蓝色";
    }
}

// 抽象角色和扩展修正

abstract class Bag{
    protected Color color;
    protected Brand brand;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public Brand getBrand() {
        return brand;
    }

    abstract String getName();
}
class HandBag extends Bag{

    public HandBag(Color color,Brand brand) {
        super();
        super.setColor(color);
        super.setBrand(brand);
    }

    @Override
    String getName() {
        return color.getColor()+"-挎包";
    }
}class Wallet extends Bag{

    public Wallet(Color color,Brand brand) {
        super();
        super.setColor(color);
        super.setBrand(brand);
    }

    @Override
    String getName() {
        return color.getColor()+brand.getBrand()+"钱包";
    }
}

//再次扩展，这个包还有品牌属性
interface Brand{
    String getBrand();
}
class Lv implements Brand{

    @Override
    public String getBrand() {
        return "LV";
    }
}