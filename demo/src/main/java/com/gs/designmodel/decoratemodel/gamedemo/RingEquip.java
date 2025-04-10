package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:46
 *
 * 戒指---->攻击力5
 **/
public class RingEquip implements IEquip{
    @Override
    public int calculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "魔戒";
    }
}