package com.gs.designmodel.bridge.common;

/**
 * @author: Gaos
 * @Date: 2023-08-09 16:24
 **/
public class LargeCoffeeWithSugar implements ICoffee{
    @Override
    public void orderCoffee(int count) {
        System.out.println("大杯加糖咖啡" + count + "杯");
    }
}