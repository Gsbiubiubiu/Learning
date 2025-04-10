package com.gs.designmodel.bridge.common;

/**
 * @author: Gaos
 * @Date: 2023-08-09 16:21
 *
 * 加糖咖啡
 **/
public class CoffeeWithSugar implements ICoffee{
    @Override
    public void orderCoffee(int count) {
        System.out.println("加糖咖啡" + count + "杯");
    }
}

