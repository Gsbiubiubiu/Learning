package com.gs.designmodel.bridge.special;

/**
 * @author: Gaos
 * @Date: 2023-08-09 20:03
 **/
public class Test {

    public static void main(String[] args) {
        // 两倍加奶的大杯咖啡
        RefinedCoffee largeCoffee = new LargeCoffee(new Milk());
        largeCoffee.orderCoffee(2);
        largeCoffee.checkQuality();
    }
}