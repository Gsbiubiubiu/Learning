package com.gs.designmodel.factorymodel.easy;

/**
 * @author: Gaos
 * @Date: 2022-11-17 10:35
 *
 * 辣味肉夹馍
 **/
public class LaRouJiaMo extends RouJiaMo {


    public LaRouJiaMo() {
        this.name = "辣味肉夹馍";
    }

    @Override
    public void sell() {
        System.out.println("卖出了一个" + name);
    }
}