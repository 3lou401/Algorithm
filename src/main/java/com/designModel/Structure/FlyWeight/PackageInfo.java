package com.designModel.Structure.FlyWeight;

import java.util.HashMap;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/13 0:02
 * @Desc: 享元模式 ： 系统中存在大量类似的对象实例，很影响性能
 *                   将相似的部分共享，
 *                   角色 ； 具体享元角色 & 不可共享角色 & 抽象享元角色 & 享元工厂
 */
public class PackageInfo {
    public static void main(String[] args) {
        FlyWeight f1 = new FlyWeightFactory().getFlyWeight("color");
        UnSupportPart unSupportPart = new UnSupportPart("13排左2");
        f1.oper(unSupportPart);
    }
}

interface  FlyWeight{
    void oper(UnSupportPart unSupportPart);
}
class UnSupportPart{
    private  String info;

    public UnSupportPart(String info) {
        this.info = info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class ConcreteFlyWeight1 implements FlyWeight{
    private  String key;

    public ConcreteFlyWeight1(String key) {
        this.key = key;
    }

    @Override
    public void oper(UnSupportPart unSupportPart) {
        System.out.printf("可以共享的是: "+key+"\n");
        System.out.printf("不能共享的是: "+unSupportPart.getInfo()+"\n");
    }
}

class FlyWeightFactory {
    private HashMap<String,FlyWeight> maps = new HashMap<>();

    public FlyWeight getFlyWeight(String key){
        FlyWeight flyWeight = maps.get(key);
        if (flyWeight == null){
            flyWeight = new ConcreteFlyWeight1(key);
            maps.put(key,flyWeight);
        } else {
            System.out.printf("享元已经存在，"+key+" 被捕获\n");
        }
        return flyWeight;
    }
}