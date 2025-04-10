package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:41
 *
 * 装备接口
 **/
public interface IEquip {

    /**
     * 计算攻击力
     * @return 攻击力
     */
    int calculateAttack();


    /**
     * 装备的描述
     * @return 装备描述
     */
    String description();

}