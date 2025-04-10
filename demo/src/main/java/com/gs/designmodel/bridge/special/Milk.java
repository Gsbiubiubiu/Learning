package com.gs.designmodel.bridge.special;

/**
 * @author: Gaos
 * @Date: 2023-08-09 19:59
 *
 * 实现化部分(咖啡口味维度)
 *
 * 加奶
 **/
public class Milk implements ICoffeeAdditives{
    @Override
    public void addSomething() {
        System.out.println("加奶");
    }
}