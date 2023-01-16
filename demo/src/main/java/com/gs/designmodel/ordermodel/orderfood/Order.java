package com.gs.designmodel.ordermodel.orderfood;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Gaos
 * @Date: 2023-01-16 11:50
 *
 *
 * 订单类
 **/
public class Order {
    // 餐桌号码
    private int diningTable;

    // 餐桌下 菜品名称及份数
    private Map<String, Integer> foodDir = new HashMap<>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String name,int num) {
        foodDir.put(name,num);
    }
}