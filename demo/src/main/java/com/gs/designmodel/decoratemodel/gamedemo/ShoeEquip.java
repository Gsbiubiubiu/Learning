package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:47
 *
 * 鞋子---->攻击力5
 **/
public class ShoeEquip implements IEquip{
    @Override
    public int calculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "法穿鞋";
    }
}