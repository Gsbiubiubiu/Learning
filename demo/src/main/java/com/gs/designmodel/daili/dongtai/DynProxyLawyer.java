package com.gs.designmodel.daili.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:25
 *
 * 动态代理类
 **/
public class DynProxyLawyer implements InvocationHandler {

    private Object target;

    public DynProxyLawyer(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("法庭公告案件进展: " + method.getName());
        // 执行
        Object result = method.invoke(target, args);
        return result;
    }
}