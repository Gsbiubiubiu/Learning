package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:55
 *
 * 红宝石装饰品--->攻击力+15
 **/
public class RedGemDecorator extends IEquipDecorator{
    public RedGemDecorator(IEquip equip) {
        super(equip);
    }
    @Override
    public int calculateAttack() {
        return 15 + super.calculateAttack();
    }

    @Override
    public String description() {
        return super.description() + "-----红宝石";
    }
}