package com.gs.designmodel.prototype.three;

/**
 * @author: Gaos
 * @Date: 2023-07-21 15:30
 **/
public class Test {
    public static void main(String[] args) {
        DeepCopy deepCopy = new DeepCopy();
        deepCopy.setValue("张三");

        DeepCopy clone = deepCopy.clone();
        clone.setValue("李四");

        System.out.println("原始对象：" + deepCopy.getValue());
        System.out.println("复制对象：" + clone.getValue());
    }
}