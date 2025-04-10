package com.gs.designmodel.bridge.special;

/**
 * @author: Gaos
 * @Date: 2023-08-09 20:00
 *
 * 实现化部分(咖啡口味维度)
 *
 * 加糖
 **/

public class Sugar implements ICoffeeAdditives{
    @Override
    public void addSomething() {
        System.out.println("加糖");
    }
}