package com.concurrent.jcstress;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.II_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/4/20
 * Time: 21:56
 * Description: No Description
 */
// 指定使用并发测试
@JCStressTest
// 预测的结果与类型，附加描述信息
@Outcome(id = {"1", "4"}, expect = ACCEPTABLE, desc = "ok")
@Outcome(id = "0", expect = ACCEPTABLE_INTERESTING, desc = "!!!")
// 标注需要测试的类
@State
public class TestJMM {
    int num = 0;
    volatile boolean ready = false;

    // 标记方法使用多线程
    @Actor
    public void actor1(II_Result r) {
        //ready是volatile的，读取值带读屏障
        if (ready) {
            r.r1 = num + num;
        } else {
            r.r1 = 1;
        }
    }
    @Actor
    public void actor2(II_Result r) {
        num = 2;
        ready = true;
        //写屏障
    }
}
