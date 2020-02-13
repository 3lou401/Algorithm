package com.designModel.Structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/12 0:24
 * @Desc:
 */
public class CglibUseCase {
    public static void main(String[] args) {
        Sing sing = new Singer(); //target

        Sing proxy = (Sing) new ProxyFactory(sing).getProxyInstance();
        proxy.sing();
    }
}

