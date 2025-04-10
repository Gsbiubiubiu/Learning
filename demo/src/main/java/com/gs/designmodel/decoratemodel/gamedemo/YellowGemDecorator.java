package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:53
 *
 * 黄宝石---->攻击力+10
 **/
public class YellowGemDecorator extends IEquipDecorator {


    public YellowGemDecorator(IEquip equip) {
        super(equip);
    }

    @Override
    public int calculateAttack() {
        return 10 + super.calculateAttack();
    }

    @Override
    public String description() {
        return super.description() + "-----黄宝石";
    }
}