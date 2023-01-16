package com.gs.designmodel.factorymodel.abstractfactory;

import com.gs.designmodel.factorymodel.easy.RouJiaMo;

/**
 * @author: Gaos
 * @Date: 2022-11-17 13:59
 *
 * 如果我们现在不想只 单纯的买肉夹馍 而希望加一个手抓饼
 * 抽象一个食品工厂出来 原本只有生产肉夹馍的抽象接口，现在增加生产手抓饼的抽象接口
 *
 **/
public abstract class FoodFactory {

    public abstract RouJiaMo makeRouJiaMo(String type);

    //public abstract ShouZhuaBing makeRouJiaMo();
}