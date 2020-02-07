package com.designModel.active.ChainOfReponsebility;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/5 11:30
 * @Desc: 请假条示例 ， 小于一天 组长审批； 两天， 经理审批 ； 五天，主任审批
 */
public class UseCase {
    public static void main(String[] args) {
        Leader zuZhang = new ZuZhang();
        Leader jingLi = new JingLi();
        Leader zhuRen = new ZhuRen();
        zuZhang.setLeader(jingLi);
        jingLi.setLeader(zhuRen);
        zuZhang.approve(4);
    }
}

abstract  class Leader{
 private Leader leader;

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
    abstract void approve(int day);
}

class ZuZhang extends Leader{

    @Override
    void approve(int day) {
        if (day <= 1){
            System.out.printf("组长 ： 允许请假\n");
        }else {
            if (getLeader() != null)
                getLeader().approve(day);
            else
                System.out.printf("不允许请假\n");
        }
    }
}
class JingLi extends Leader{

    @Override
    void approve(int day) {
        if (day > 1 && day <= 2){
            System.out.printf("经理 ： 允许请假\n");
        }else {
            if (getLeader() != null)
                getLeader().approve(day);
            else
                System.out.printf("不允许请假\n");
        }
    }
}
class ZhuRen extends Leader{

    @Override
    void approve(int day) {
        if (day > 3 && day <= 5){
            System.out.printf("主任 ： 允许请假\n");
        }else {
            if (getLeader() != null)
                getLeader().approve(day);
            else
                System.out.printf("不允许请假\n");
        }
    }
}