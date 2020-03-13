package com.designModel.active.Memento;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/2 14:34
 * @Desc: 黑箱实现备忘录模式 : 和白箱模式的区别是
 *          管理者不知道备忘录角色的内部细节
 */
public class MementoBlack {
    public static void main(String[] args) {
        //管理者只知道一个接口 MementoInterface ,不知道具体细节
        OriginatorB originatorB = new OriginatorB();
        originatorB.setState("开始");
       MementoInterface mementoInterface =  originatorB.saveMementoB(); //要保存状态
        CaretakerB caretakerB = new CaretakerB();
        caretakerB.saveMementoB(mementoInterface);
        //修改状态，打印，恢复状态，打印
        originatorB.setState("中间过程");
        System.out.println("当前状态 ："+originatorB.getState());
        originatorB.restoreState(caretakerB.getMementoB());
        System.out.println("恢复为修改前的状态 ："+originatorB.getState());
    }
}
//发起人
class OriginatorB{
    private String state;
    public String getState() { return state;    }
    public void setState(String state) {  this.state = state;    }
    //保存带状态的memento
    public MementoInterface saveMementoB(){  return new RealMemento(this.state);    }
    //还原状态
    public void restoreState(MementoInterface mementoB){
        RealMemento mementoB1 =(RealMemento) mementoB;
        this.state = mementoB1.getState();
    }

    protected class RealMemento implements MementoInterface {
        private String state;
        public String getState() {  return state;    }
        public void setState(String state) { this.state = state;   }
        public RealMemento(String state) {  this.state = state;      }
    }
}
//抽象备忘录角色 ： 黑箱
interface MementoInterface {}
//发起人角色
class CaretakerB{
    private MementoInterface mementoB;
    public MementoInterface getMementoB() { return mementoB;  }
    public void saveMementoB(MementoInterface mementoB) {  this.mementoB = mementoB;    }
}


