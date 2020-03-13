package com.designModel.build.AbstractFactoryPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/21 11:32
 * @Desc:  抽象工厂模式 ： 举例 美的工厂生产美的电视机和美的空调 ， TCL工厂生产TCL电视机和TCL空调
 *              产品族 ： 美的生产的电视机和空调就是一个产品族
 *              产品等级： 继承自一个父类的各个子类， 比如 美的空调和TCL空调
 *
 *           核心逻辑 ： 一个具体工厂生产多个产品等级 &一个产品族的产品
 *           角色 ：抽象产品角色（一个等级一个） & 具体产品 & 抽象工厂（一个产品等级对应一个生产方法）&具体工厂
 */
public class PackageInfo {
    public static void main(String[] args) {
        Factory fa = new Meidi();
        KongTiao kongTiao = fa.produceKongTiao();
        kongTiao.zhiLeng();
    }
}
interface KongTiao {
    void zhiLeng();
}
class MeidiKongTiao implements KongTiao {

    @Override
    public void zhiLeng() {
        System.out.printf("美的空调制冷。。。\n");
    }
}
class HaierKongTiao implements KongTiao {
    @Override
    public void zhiLeng() {
        System.out.printf("海尔空调制冷。。。\n");
    }
}
interface TV{
    void play();
}
class MeidiTV implements TV{

    @Override
    public void play() {
        System.out.printf("美的TV播放电视。。。");
    }
}
class HaierTV implements TV{

    @Override
    public void play() {
        System.out.printf("海尔TV播放电视。。。");
    }
}

interface Factory{
    KongTiao produceKongTiao();
    TV produceTV();
}
class Meidi implements Factory{
    @Override
    public KongTiao produceKongTiao() {
        System.out.printf("我在生产美的空调。。\n");
        return new MeidiKongTiao();
    }
    @Override
    public TV produceTV() {
        System.out.printf("我在生产美的电视。。\n");
        return new MeidiTV();
    }
}
class Haier implements Factory{
    @Override
    public KongTiao produceKongTiao() {
        System.out.printf("我在生产海尔空调。。\n");
        return new HaierKongTiao();
    }

    @Override
    public TV produceTV() {
        System.out.printf("我在生产海尔电视。。\n");
        return new HaierTV();
    }
}