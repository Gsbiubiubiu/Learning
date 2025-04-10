package com.gs.designmodel.bridge.common;

/**
 * @author: Gaos
 * @Date: 2023-08-09 16:20
 *
 * 原味咖啡
 **/
public class CoffeeOriginal implements ICoffee{

    @Override
    public void orderCoffee(int count) {
        System.out.println("原味咖啡" + count + "杯");
    }
}