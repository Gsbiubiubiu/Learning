package com.gs.designmodel.ordermodel.orderfood;

/**
 * @author: Gaos
 * @Date: 2023-01-16 11:54
 *
 * 厨师类，是命令的执行者
 **/
public class SeniorChef {

    // 根据餐品及份数制作食物
    public void makeFood(String name, int num) {
        System.out.println(num  + "份" + name);
    }
}