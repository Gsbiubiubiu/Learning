package com.gs.designmodel.bridge.special;

import java.util.Random;

/**
 * @author: Gaos
 * @Date: 2023-08-09 19:56
 **/
public abstract class RefinedCoffee extends Coffee{

    public RefinedCoffee(ICoffeeAdditives additives) {
        super(additives);
    }

    public void checkQuality() {
        Random random = new Random();
        System.out.println(String.format("%s 添加%s", additives.getClass().getSimpleName(), random.nextBoolean()? "太多" :"合格"));
    }
}