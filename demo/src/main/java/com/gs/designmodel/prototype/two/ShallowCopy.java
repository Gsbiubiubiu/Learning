package com.gs.designmodel.prototype.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-07-21 15:07
 *
 * 浅拷贝
 **/
public class ShallowCopy implements Cloneable{

    private List<String> list = new ArrayList<>();

    @Override
    public ShallowCopy clone() {
        try {
            ShallowCopy clone = (ShallowCopy) super.clone();
            // TODO:复制此处的可变状态，这样此克隆就不能更改初始克隆的内部项
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void setValue(String value) {
        this.list.add(value);
    }

    public List<String> getValue() {
        return this.list;
    }
}