package com.gs.designmodel.bridge.special;

/**
 * @author: Gaos
 * @Date: 2023-08-09 20:02
 *
 *  实现抽象化部分(咖啡的容量维度)
 *  小杯
 *
 **/

public class SmallCoffee extends RefinedCoffee{


    public SmallCoffee(ICoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void orderCoffee(int count) {
        additives.addSomething();
        System.out.println("小杯咖啡" + count + "杯");
    }
}