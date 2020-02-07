package com.designModel.active.strategy;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 15:37
 * @Desc: 例子 ，出门旅游可以选择多种方式 ： 汽车、火车、飞机
 */
public class UseCase {
    public static void main(String[] args) {
        Travel t = new ByAir();
        WayTravel wayTravel = new WayTravel();
        wayTravel.setTravel(t);
        wayTravel.travel();
    }
}

interface  Travel{
    void goOut();
}
class ByCar implements Travel{
    public void goOut(){
        System.out.printf("坐汽车\n");
    }
}
class ByTrain implements Travel{
    public void goOut(){
        System.out.printf("坐火车\n");
    }
}
class ByAir implements Travel{
    public void goOut(){
        System.out.printf("坐飞机\n");
    }
}

//环境类
class WayTravel{
    private Travel travel;

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
    public void travel(){
        travel.goOut();
    }
}