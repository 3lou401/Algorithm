package com.designModel.active.strategy;

import java.util.HashMap;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/4 15:55
 * @Desc: 当策略很多时，客户端管理很复杂，可以在环境类中使用策略工厂
 */
public class StrategyFacotryCase {
}

interface StrategyP{
    void solution();
}

class ConcreteA implements StrategyP{
    public void solution(){
        System.out.printf("具体算法A\n");
    }
}class ConcreteB implements StrategyP{
    public void solution(){
        System.out.printf("具体算法B\n");
    }
}

// 环境类中持有一个工厂
class ContextP{
    private HashMap<String,StrategyP> fac = new HashMap<>();

    public ContextP() {
        fac.put("default",new ConcreteA());
    }

    public StrategyP get(String key){
        if (!fac.containsKey(key)){
            return fac.get("default");
        }
        return fac.get(key);
    }
    public void put(String key, StrategyP strategyP){
        //重复就覆盖策略
        fac.put(key,strategyP);
    }
    public void  sol(String s){
        get("s").solution();
    }
}
