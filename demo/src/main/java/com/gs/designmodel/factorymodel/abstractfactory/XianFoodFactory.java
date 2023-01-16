package com.gs.designmodel.factorymodel.abstractfactory;

import com.gs.designmodel.factorymodel.easy.LaRouJiaMo;
import com.gs.designmodel.factorymodel.easy.RouJiaMo;
import com.gs.designmodel.factorymodel.easy.SuanRouJiaMo;
import com.gs.designmodel.factorymodel.easy.TianRouJiaMo;

/**
 * @author: Gaos
 * @Date: 2022-11-17 14:08
 *
 * 交由各个具体地区具体实现
 *
 * 对应的手抓饼包括不同口味的实体类 这里就不再创建了
 **/
public class XianFoodFactory extends FoodFactory {
    @Override
    public RouJiaMo makeRouJiaMo(String type) {
            RouJiaMo rouJiaMo = null;
            if(type.equals("Suan")) {
                rouJiaMo = new SuanRouJiaMo();
            }else if(type.equals("La")) {
                rouJiaMo = new LaRouJiaMo();
            }else if (type.equals("Tian")){
                rouJiaMo = new TianRouJiaMo();
            }else {
                throw new RuntimeException("没有此种类的肉夹馍");
            }
            return rouJiaMo;
    }
}