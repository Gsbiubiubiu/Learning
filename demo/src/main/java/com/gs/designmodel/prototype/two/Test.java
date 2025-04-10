package com.gs.designmodel.prototype.two;

/**
 * @author: Gaos
 * @Date: 2023-07-21 15:11
 **/
public class Test {
    public static void main(String[] args) {
        ShallowCopy shallowCopy = new ShallowCopy();
        shallowCopy.setValue("张三");

        // 此处克隆了一个对象
        ShallowCopy clone = shallowCopy.clone();
        clone.setValue("李四");
        // 输出原始对象
        System.out.println(shallowCopy.getValue());
        // 输出克隆对象
        System.out.println(clone.getValue());
    }
}