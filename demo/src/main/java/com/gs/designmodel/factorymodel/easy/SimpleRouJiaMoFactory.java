package com.gs.designmodel.factorymodel.easy;

/**
 * @author: Gaos
 * @Date: 2022-11-17 10:52
 **/
public class SimpleRouJiaMoFactory {

    public RouJiaMo createRoujiaMo(String type){
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