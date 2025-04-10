package com.gs.designmodel.daili.cglib;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:38
 **/
public class Test {

    public static void main(String[] args) {
        Frank cProxy = (Frank) CgProxyFactory.getCgLibDynProxy(new Frank());
        cProxy.submit("银行卡记录在此");
        cProxy.defend();
    }
}