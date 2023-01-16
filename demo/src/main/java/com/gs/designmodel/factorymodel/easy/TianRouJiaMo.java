package com.gs.designmodel.factorymodel.easy;

/**
 * @author: Gaos
 * @Date: 2022-11-17 10:44
 * 甜肉夹馍
 **/
public class TianRouJiaMo extends RouJiaMo{

    public TianRouJiaMo() {
        this.name = "甜肉夹馍";
    }

    @Override
    public void sell() {
        System.out.println("卖出了一个" + name);
    }
}