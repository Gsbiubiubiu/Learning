package com.gs.designmodel.factorymodel.easy;

/**
 * @author: Gaos
 * @Date: 2022-11-17 10:29
 *
 * 首先你需要一个销售肉夹馍的门店, 有一个销售肉夹馍的方法
 **/
public class RoujiaMoStore {

    private SimpleRouJiaMoFactory rouJiaMoFactory;

    public RoujiaMoStore(SimpleRouJiaMoFactory rouJiaMoFactory) {
        this.rouJiaMoFactory = rouJiaMoFactory;
    }

    /**
     * 销售肉夹馍方法v1
     * @param type
     * @return
     */
//    public RouJiaMo sellRouJiaMoV1(String type) {
//        RouJiaMo rouJiaMo = null;
//        if(type.equals("Suan")) {
//            rouJiaMo = new SuanRouJiaMo();
//        }else if(type.equals("La")) {
//            rouJiaMo = new LaRouJiaMo();
//        }else if (type.equals("Tian")){
//            rouJiaMo = new TianRouJiaMo();
//        }else {
//            throw new RuntimeException("没有此种类的肉夹馍");
//        }
//        rouJiaMo.prepare();
//        rouJiaMo.pack();
//        rouJiaMo.fire();
//        rouJiaMo.sell();
//        return rouJiaMo;
//    }
    /*
        这样设计可以支持你卖肉夹馍，但是销售肉夹馍方法和生产肉夹馍的种类耦合度太高了。
        也就是说我们每增加或删除几种口味，都需要修改里面的方法，并不解藕
        我们可以吧生产肉夹馍单拿出来作为一个工厂，以组合的方式和肉夹馍门店结合起来
     */

    /**
     * 销售肉夹馍方法v1
     * @param type
     * @return
     */
    public RouJiaMo sellRouJiaMoV2(String type) {
        RouJiaMo roujiaMo = rouJiaMoFactory.createRoujiaMo(type);
        roujiaMo.prepare();
        roujiaMo.pack();
        roujiaMo.fire();
        roujiaMo.sell();
        return roujiaMo;
    }

    /*
        现在删除或者增加种类就和销售无关了 只与工厂有关系， 这就是简单工厂模式
     */
}