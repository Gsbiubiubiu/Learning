package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:46
 *
 * 护腕---->攻击力5
 **/
public class WristEquip implements IEquip{

    @Override
    public int calculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "平凡无奇的护腕";
    }
}