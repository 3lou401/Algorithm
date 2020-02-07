package com.designModel.active.strategy;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 15:06
 * @Desc: 策略模式，
 */
public class packageInfo {
    public static void main(String[] args) {
        Context c = new Context();
        c.contextSol();

        System.out.printf("接下来用算法B\n");
        Strategy bs = new ConcreteStrategyB();
        c.setS(bs);
        c.contextSol();
    }
}

//1 抽象策略
interface  Strategy{
    void solution();
}

//2.具体策略类
class ConcreteStrategyA implements  Strategy{
    public void solution(){
        System.out.printf("这是具体算法A\n");
    }
}class ConcreteStrategyB implements  Strategy{
    public void solution(){
        System.out.printf("这是具体算法B\n");
    }
}
//3、环境类
class Context{
    Strategy s;

    public Context() {
        this.s = new ConcreteStrategyA();
    }
    public  void setS(Strategy s){
        this.s = s;
    }
    public void contextSol(){
        s.solution();
    }
}