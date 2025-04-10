package com.gs.designmodel.bridge.special;

/**
 * @author: Gaos
 * @Date: 2023-08-09 19:55
 *
 * 创建抽象化部分的接口定义(咖啡容量的维度)
 **/
public abstract class Coffee {

    protected ICoffeeAdditives additives;

    public Coffee(ICoffeeAdditives additives) {
        this.additives = additives;
    }

    public abstract void orderCoffee(int count);

}