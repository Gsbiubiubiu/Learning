package com.gs.designmodel.state.real;

/**
 * @author: Gaos
 * @Date: 2023-07-17 10:07
 *
 * 没有钱的状态
 **/
public class NoMoneyState implements State{

    private VendingMachine machine;

    public NoMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("投币成功");
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void backMoney() {
        System.out.println("未投币，无法退钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("未投币，无法转动");
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("非法状态");
    }
}