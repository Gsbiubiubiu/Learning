package com.gs.designmodel.factorymodel.factorymethod;

import com.gs.designmodel.factorymodel.easy.RouJiaMo;

/**
 * @author: Gaos
 * @Date: 2022-11-17 11:54
 *
 *
 * 决定去西安开个分店，去北京开个分店。既然有分店了，那总店就是抽象的了：
 **/
public abstract class RoujiaMoStore {

    /**
     * 创建实例的过程交由各个子类实现
     * @param type
     * @return
     */
    public abstract RouJiaMo createRouJiaMo(String type);

    /**
     * 根据传入类型卖不同的肉夹馍
     *
     * @param type
     * @return
     */
    public RouJiaMo sellRouJiaMo(String type)
    {
        RouJiaMo rouJiaMo = createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}