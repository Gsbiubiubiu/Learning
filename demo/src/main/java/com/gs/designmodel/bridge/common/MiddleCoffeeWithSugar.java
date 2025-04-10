package com.gs.designmodel.bridge.common;

/**
 * 中杯加糖
 */
public class MiddleCoffeeWithSugar implements ICoffee {

    @Override
    public void orderCoffee(int count) {
        System.out.println("中杯加糖" + count + "杯");
    }
}