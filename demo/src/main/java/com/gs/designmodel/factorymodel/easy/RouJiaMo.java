package com.gs.designmodel.factorymodel.easy;

/**
 * @author: Gaos
 * @Date: 2022-11-17 10:30
 * <p>
 * 你需要有各种口味的肉夹馍 所以要定义一个抽象类
 * 这里在实际中具体定义为接口或抽象类还有待商榷，
 * 按照实际的逻辑，规范性的使用接口，有共通的接口可以更好的实现代码复用的使用抽象类
 **/
public abstract class RouJiaMo {

    protected String name;

    /**
     * 准备工作
     */
    public void prepare() {
        System.out.println(name + "的准备工作");
    }

    /**
     * 包装
     */
    public void pack() {
        System.out.println(name + "的包装袋");
    }

    /**
     * 烘烤
     */
    public void fire() {
        System.out.println(name + "的特殊烘烤");
    }

    /**
     * 买出的抽象方法，交由各实现类实现
     */
    public abstract void sell();
}