package com.gs.designmodel.factorymodel.easy;

/**
 * @author: Gaos
 * @Date: 2022-11-17 10:39
 *
 * 酸味肉夹馍
 **/
public class SuanRouJiaMo extends RouJiaMo{


    public SuanRouJiaMo() {
        this.name = "酸味肉夹馍";
    }

    @Override
    public void sell() {
        System.out.println("卖出了一个" + name);
    }
}