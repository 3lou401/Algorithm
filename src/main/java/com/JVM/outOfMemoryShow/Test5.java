package com.JVM.outOfMemoryShow;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 23:08
 * Description: 测试方法区溢出，思路用动态增强的类不断填充方法区
 */
public class Test5 {
    public static void generate(){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Test5.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                return methodProxy.invoke(0,objects);
            }
        });
    }

    public static void main(String[] args) {
        while (true){
            generate();
        }
    }
}
