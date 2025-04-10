package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:50
 *
 * 装饰品（宝石）的基类接口
 **/
public class IEquipDecorator implements IEquip{

    private IEquip equip;

    public IEquipDecorator(IEquip equip) {
        this.equip = equip;
    }

    @Override
    public int calculateAttack() {
        return equip.calculateAttack();
    }

    @Override
    public String description() {
        return equip.description();
    }
}