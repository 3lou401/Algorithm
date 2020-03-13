package com.designModel.build.FactoryPattern;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/20 12:36
 * @Desc:  养马场 养马 ； 养牛场养牛
 */
public class UseCase1 {
    public static void main(String[] args) {
        String packageName = "com.designModel.build.FactoryPattern";
        String factoryName = packageName+".HorseFarm";
        AnimalFarm animalFarm = (AnimalFarm) ReadObject.getFactory(factoryName);
        Animal animal = animalFarm.feed();
        animal.show();
    }
}

interface Animal{
    void show();
}
class Horse implements Animal{
    public void  show(){
        System.out.println("马。。。。");
    }
}
class Cattle implements Animal{
    public void show(){
        System.out.println("牛。。。。");
    }
}

interface  AnimalFarm{
    Animal feed();
}
class HorseFarm implements AnimalFarm{
    public Animal feed(){
        System.out.printf("我养的是马\n");
        return new Horse();
    }
}

class CattleFarm implements AnimalFarm{
    public Animal feed(){
        System.out.printf("我养的是牛\n");
        return new Cattle();
    }
}
