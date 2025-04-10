package com.gs.designmodel.daili.jingtai;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:21
 **/
public class ProxyFactory {

    public static ILawSuit getProxy() {
        return new ProxyLawyer(new XiaoMing());
    }
}