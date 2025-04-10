package com.gs.designmodel.decoratemodel.gamedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-18 09:56
 **/
public class GameTest {
    public static void main(String[] args) {
        // 镶嵌一个红宝石 一个蓝宝石的武器
        IEquip equipFirst = new RedGemDecorator(new BlueGemDecorator(new ArmEquip()));
        System.out.println("攻击力：" + equipFirst.calculateAttack());
        System.out.println("描述：" + equipFirst.description());
        System.out.println("------------");

        // 一个镶嵌红宝石，一个镶嵌蓝宝石，一个镶嵌黄宝石的护腕
        IEquip equipSecond = new RedGemDecorator(new BlueGemDecorator(new YellowGemDecorator(new WristEquip())));
        System.out.println("攻击力：" + equipSecond.calculateAttack());
        System.out.println("描述：" + equipSecond.description());
        System.out.println("------------");
    }
}