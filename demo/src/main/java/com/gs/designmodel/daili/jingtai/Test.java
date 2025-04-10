package com.gs.designmodel.daili.jingtai;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:22
 **/
public class Test {
    public static void main(String[] args) {
        ProxyFactory.getProxy().submit("工资卡流水");
        ProxyFactory.getProxy().defend();
    }
}