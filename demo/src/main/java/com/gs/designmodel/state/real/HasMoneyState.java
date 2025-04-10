package com.gs.designmodel.state.real;

import java.util.Random;

/**
 * @author: Gaos
 * @Date: 2023-07-17 10:24
 * 投入币的状态
 **/
public class HasMoneyState implements State{

    private VendingMachine machine;
    private Random random = new Random();

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("您已投币，不需要再次投币");
    }

    @Override
    public void backMoney() {
        System.out.println("退币成功");
        machine.setState(machine.getNoMoneyState());
    }

    @Override
    public void turnCrank() {
        System.out.println("您转动了手柄");
        int winner = random.nextInt(10);
        if(winner == 0 && machine.getCount() > 1) {
            machine.setState(machine.getWinnerState());
        }else {
            machine.setState(machine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("非法状态，请检查");
    }
}