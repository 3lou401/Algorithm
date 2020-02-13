package com.designModel.Structure.adapter;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 13:38
 * @Desc: 比如现在 油电车，可以用油，也可以用电； 但司机只关心前进
 */
public class UseCase {
}

interface  Car{
    void dirve();
}

// 烧油电机
class OilDirver{
    public void useOil(){
        System.out.printf("我在用油前进");
    }
}

// 适配器1
class OilAdapter implements Car{
    private OilDirver oilDirver;

    public OilAdapter() {
        this.oilDirver = new OilDirver();
    }

    @Override
    public void dirve() {
        oilDirver.useOil();
    }
}

//电机
class Electric{
    public void useEle(){
        System.out.printf("我输出电能...\n");
    }
}

class ElectricAdapter implements Car{
    private Electric electric;

    public ElectricAdapter() {
        this.electric = new Electric();
    }

    @Override
    public void dirve() {
        electric.useEle();
    }
}