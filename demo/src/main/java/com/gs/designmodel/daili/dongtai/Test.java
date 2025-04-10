package com.gs.designmodel.daili.dongtai;

import com.gs.designmodel.daili.jingtai.ILawSuit;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:29
 **/
public class Test {

    public static void main(String[] args) {
        ILawSuit proxy = (ILawSuit) DongProxyFactory.getDynProxy(new XiaoHua());
        proxy.submit("工资卡流水如下:");
        proxy.defend();
    }
}