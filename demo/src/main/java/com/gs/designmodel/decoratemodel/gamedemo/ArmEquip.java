package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:44
 *
 * 武器--->攻击力20
 **/
public class ArmEquip implements IEquip{

    @Override
    public int calculateAttack() {
        return 20;
    }

    @Override
    public String description() {
        return "屠龙刀";
    }
}