package com.gs.designmodel.daili.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:37
 **/
public class CgProxyFactory {

    public static Object getCgLibDynProxy(Object targe) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targe.getClass());
        enhancer.setCallback(new CgLibDynProxyLawyer());
        Object targetProxy = enhancer.create();
        return targetProxy;
    }
}