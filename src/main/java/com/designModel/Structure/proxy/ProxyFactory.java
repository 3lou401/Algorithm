package com.designModel.Structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 0:45
 * @Desc:
 */
class ProxyFactory implements MethodInterceptor {

    //    维护目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.printf("拦截业务代码，前置处理...\n");
        Object returnVal = methodProxy.invokeSuper(obj,args);
        System.out.printf("拦截业务代码，收尾...\n");
        return returnVal;
    }
}