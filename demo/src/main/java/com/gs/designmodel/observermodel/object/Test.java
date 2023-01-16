package com.gs.designmodel.observermodel.object;

/**
 * @author: Gaos
 * @Date: 2022-10-31 16:40
 *
 * 观察者模式 测试类
 **/

public class Test {
    public static void main(String[] args) {
        // 模拟3d服务号
        ObjectFor3D objectFor3D = new ObjectFor3D();
        // 客户1
        ObserverOne observerOne = new ObserverOne(objectFor3D);
        // 客户2
        ObserverTwo observerTwo = new ObserverTwo(objectFor3D);

        objectFor3D.setMessage("20221031的3d号码是：12345");
        objectFor3D.setMessage("20221030的3d号码是：54321");
    }
}