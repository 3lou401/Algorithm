package com.designModel.Structure.adapter;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 13:51
 * @Desc: 双向适配器
 */
public class TwoWayAdaptePattern {
    public static void main(String[] args) {

        System.out.printf("target通过适配器访问...\n");
        IAdaptee adaptee = new AdapterTw();
        ITarget target  = new TwoWayAdapter(adaptee);
        target.request();

    }
}

interface  ITarget{
    void request();
}
interface  IAdaptee{
    void speciReq();
}

class TargetTw implements ITarget{

    @Override
    public void request() {
        System.out.printf("target的方法\n");
    }
}

class AdapterTw implements IAdaptee{

    @Override
    public void speciReq() {
        System.out.printf("目标角色的方法\n");
    }
}

class TwoWayAdapter implements ITarget,IAdaptee{

    private  ITarget target;

    private IAdaptee adaptee;

    public TwoWayAdapter(ITarget target) {
        this.target = target;
    }

    public TwoWayAdapter(IAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.speciReq();
    }

    @Override
    public void speciReq() {
        target.request();
    }
}


