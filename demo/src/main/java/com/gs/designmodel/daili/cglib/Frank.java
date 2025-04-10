package com.gs.designmodel.daili.cglib;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:33
 *
 * 定义业务类，被代理的类没有实现任何接口
 **/
public class Frank {
    public void submit(String proof) {
        System.out.println("老板带着小姨子欠薪跑路了，证据如下: " + proof);
    }

    public void defend() {
        System.out.println("审判结果，10号之前必须还钱");
    }
}