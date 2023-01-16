package com.gs.designmodel.factorymodel.factorymethod;

import com.gs.designmodel.factorymodel.easy.LaRouJiaMo;
import com.gs.designmodel.factorymodel.easy.RouJiaMo;
import com.gs.designmodel.factorymodel.easy.SuanRouJiaMo;
import com.gs.designmodel.factorymodel.easy.TianRouJiaMo;

/**
 * @author: Gaos
 * @Date: 2022-11-17 11:57
 **/
public class XianRouJiaMoStore extends RoujiaMoStore{
    @Override
    public RouJiaMo createRouJiaMo(String type) {
        RouJiaMo rouJiaMo = null;
        if (type.equals("Suan"))
        {
            rouJiaMo = new SuanRouJiaMo(); // 这里其实应该是各个地区下的 口味肉夹馍 懒得写了

        } else if (type.equals("Tian"))
        {
            rouJiaMo = new TianRouJiaMo();
        } else if (type.equals("La"))
        {
            rouJiaMo = new LaRouJiaMo();
        }

        return rouJiaMo;
    }

    @Override
    public RouJiaMo sellRouJiaMo(String type) {

        return super.sellRouJiaMo(type);
    }
}