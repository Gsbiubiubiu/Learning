package com.gs.designmodel.ordermodel.orderfood;

import java.util.Map;
import java.util.Set;

/**
 * @author: Gaos
 * @Date: 2023-01-16 13:57
 *
 * 订单命令类， 属于具体的命令类， 需要聚合 对象接收者和接收者依赖的操作数据
 **/
public class FoodCommand implements Command{

    /**
     * 持有接收者对象
     */
    private SeniorChef receiver;

    /**
     * 订单，依赖者需要接受的数据
     */
    private Order order;

    public FoodCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单");
        Map<String, Integer> foodDir = order.getFoodDir();
        Set<String> keys = foodDir.keySet();
        for (String item : keys) {
            receiver.makeFood(item, foodDir.get(item));
        }
        System.out.println(order.getDiningTable() + "桌的订单已制作完毕！！！！！");
    }

    @Override
    public void undo() {

    }
}