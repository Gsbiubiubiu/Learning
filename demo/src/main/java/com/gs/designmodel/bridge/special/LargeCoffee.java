package com.gs.designmodel.bridge.special;

/**
 * @author: Gaos
 * @Date: 2023-08-09 20:01
 *
 * 实现抽象化部分(咖啡的容量维度)
 * 大杯
 **/
public class LargeCoffee extends RefinedCoffee{

    public LargeCoffee(ICoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee(int count) {
        additives.addSomething();
        System.out.println("大杯咖啡" + count + "杯");
    }
}