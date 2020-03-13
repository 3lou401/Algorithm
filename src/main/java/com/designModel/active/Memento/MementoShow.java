package com.designModel.active.Memento;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/2 14:04
 * @Desc: 白箱备忘录模式
 */
public class MementoShow {
    public static void main(String[] args) {
        //使用Mementos备份发起人的状态
        OriginatorS initial = new OriginatorS();
        initial.setState("initial");
        MementoS memento = initial.saveState();
        //管理者  管理这个备忘录角色
        CareTakers careTakers = new CareTakers();
        careTakers.saveMementoS(memento);

        //发起人状态改变了
        initial.setState("running");
        System.out.println("temp state :"+initial.getState());
        initial.restoreState(careTakers.retireMementoS());
        System.out.println("还原后的状态 ：" + initial.getState());
    }
}

//发起人
class OriginatorS {
    private String state ; // 这就是要保存的状态
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    //创建一个备忘录对象
    public MementoS saveState(){
        return new MementoS(state);
    }
    //    恢复状态
    public void restoreState(MementoS mementoS){
        this.state =mementoS.getState();
    }
}
// 备忘录角色 ：用来保存状态
class MementoS{
    private String state; // 用来保存发起人的state
    public MementoS(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
//管理者 ： 对备忘录进行管理
class CareTakers{
    private MementoS mementoS;
    public MementoS retireMementoS() {
        return mementoS;
    }
    public void saveMementoS(MementoS mementoS) {
        this.mementoS = mementoS;
    }
}


