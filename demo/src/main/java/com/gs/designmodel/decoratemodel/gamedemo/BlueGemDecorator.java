package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:51
 *
 * 蓝色宝石装饰品
 * 攻击力+5
 **/
public class BlueGemDecorator extends IEquipDecorator{

    public BlueGemDecorator(IEquip equip) {
        super(equip);
    }

    @Override
    public int calculateAttack() {
        return 5 + super.calculateAttack();
    }

    @Override
    public String description() {
        return super.description() + "-----蓝宝石";
    }
}