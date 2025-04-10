package com.gs.designmodel.bridge.common;

/**
 * @author: Gaos
 * @Date: 2023-08-09 16:25
 **/
public class SmallCoffeeWithSugar implements ICoffee{
    @Override
    public void orderCoffee(int count) {
        System.out.println("小杯加糖咖啡" + count + "杯");
    }
}