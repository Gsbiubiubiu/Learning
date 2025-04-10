package com.gs.designmodel.state.test;

/**
 * @author: Gaos
 * @Date: 2023-07-17 11:11
 **/
public class Test {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(10);
        machine.insertMoney();
        machine.backMoney();

        System.out.println("-----------");

        machine.insertMoney();
        machine.turnCrank();

        System.out.println("------------");
        machine.insertMoney();
        machine.insertMoney();
        machine.turnCrank();
        machine.turnCrank();
        machine.backMoney();
        machine.turnCrank();
    }
}