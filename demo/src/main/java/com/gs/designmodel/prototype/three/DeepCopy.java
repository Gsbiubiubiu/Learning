package com.gs.designmodel.prototype.three;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-07-21 15:19
 *
 * 深拷贝
 **/
public class DeepCopy implements Cloneable, Serializable {

    private ArrayList<String> list = new ArrayList<>();


//    @Override
//    public DeepCopy clone() {
//        try {
//            ByteArrayOutputStream bao = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(bao);
//            oos.writeObject(this);
//
//            ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
//            ObjectInputStream ois = new ObjectInputStream(bis);
//            return (DeepCopy) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public DeepCopy clone() {
        try {
            DeepCopy clone = (DeepCopy) super.clone();
            // 数组及引用类型需要单独进行clone，假如List<Student>类型 那对于List中所有引用对象都需要进行循环clone
            clone.list = (ArrayList<String>)this.list.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setValue(String value) {
        this.list.add(value);
    }

    public List<String> getValue() {
        return this.list;
    }
}