package com.gs.designmodel.ordermodel.orderfood;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-01-16 14:02
 *
 *  服务员类 （调用者或请求者角色）
 **/
public class Waitor {
    /**
     * 持有多个命令对象
     */
    private List<Command>  commands = new ArrayList<>();

    public void setCommand(Command command) {
        commands.add(command);
    }

    /**
     *  发动命令功能， （其实是给大厨下订单的过程 --> 调用执行方法）
     */
    public void orderUp() {
        System.out.println("服务员 ： 有新的订单了");
        for (Command item : commands) {
            if(item != null) {
                item.execute();
            }
        }
    }

    public static void main(String[] args) {
        //创建第一个订单对象
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("西红柿鸡蛋面",1);
        order1.setFood("小杯可乐",2);

        //创建第二个订单对象
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("尖椒肉丝盖饭",1);
        order2.setFood("小杯雪碧",1);

        //创建厨师对象
        SeniorChef receiver = new SeniorChef();
        //创建命令对象
        FoodCommand cmd1 = new FoodCommand(receiver,order1);
        FoodCommand cmd2 = new FoodCommand(receiver,order2);

        //创建调用者（服务员对象）
        Waitor invoke = new Waitor();
        invoke.setCommand(cmd1);
        invoke.setCommand(cmd2);

        //让服务员发起命令
        invoke.orderUp();
    }
}