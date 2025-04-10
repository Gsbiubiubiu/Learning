package com.gs.designmodel.prototype.one;

/**
 * @author: Gaos
 * @Date: 2023-07-21 14:27
 **/
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体原型创建成功！");
    }


    @Override
    public Realizetype clone() {
        try {
            System.out.println("具体原型复制成功");
            return (Realizetype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}