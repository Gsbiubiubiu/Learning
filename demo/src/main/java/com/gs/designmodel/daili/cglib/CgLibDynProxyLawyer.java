package com.gs.designmodel.daili.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:34
 *
 * 拦截器 类似jdk中的InvocationHandler
 **/
public class CgLibDynProxyLawyer implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("submit")) {
            System.out.println("案件提交成功，证据如下： " + Arrays.asList(objects));
        }
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}