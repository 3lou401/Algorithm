package com.designModel.active.strategy;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/1 12:15
 * @Desc: 利用装饰者模式和策略模式 图书打折策略
 */
//环境类
public class StrategyDecorator {
    public static void main(String[] args) {
        double price = 8.2 ;
        Discount nodiscunt = new NoDiscount();
        Discount ratioDiscount = new DiscountRatio(nodiscunt,0.2);
        System.out.println("价格为 ： "+ ratioDiscount.calcu(10));
    }
}

// 抽象策略
abstract class Discount {
    private Discount discount;
    public Discount getDiscount() {
        return discount;
    }
    public Discount() { }
    public Discount(Discount discount) {
        this.discount = discount;
    }
    public abstract double calcu(double price);
}
//  具体策略1 ： 没有折扣
class NoDiscount extends Discount {
    public NoDiscount(Discount discount) {
        super(discount);
    }
    public NoDiscount() {  }
    // 没有折扣 ，不需要修改
    @Override
    public double calcu(double price) {
        if (getDiscount() == null){
            return price;
        }
        return getDiscount().calcu(price);
    }
}
// 减多少钱
class FlatDiscount extends Discount {


    private double money ;

    public FlatDiscount(Discount discount, double money) {
        super(discount);
        this.money = money;
    }

    public FlatDiscount() {
    }

    @Override
    public double calcu(double price) {
        if (getDiscount() == null){
            return price - money;
        }
        return getDiscount().calcu(price) - money;
    }
}
// 折扣
class DiscountRatio extends Discount{
    private  double ratio;

    public DiscountRatio(Discount discount, double ratio) {
        super(discount);
        this.ratio = ratio;
    }

    public DiscountRatio() {
    }

    @Override
    public double calcu(double price) {
        if (getDiscount() == null){
            return price * ratio;
        }
        return getDiscount().calcu(price) * ratio;
    }
}