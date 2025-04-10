package com.gs.designmodel.state.real;

/**
 * @author: Gaos
 * @Date: 2023-07-17 10:37
 *
 * 中奖的状态
 **/
public class WinnerState implements State{

    private  VendingMachine machine;

    public WinnerState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        throw new IllegalStateException("非法状态");
    }

    @Override
    public void backMoney() {
        throw new IllegalStateException("非法状态");

    }

    @Override
    public void turnCrank() {
        throw new IllegalStateException("非法状态");

    }

    @Override
    public void dispense() {
        System.out.println("恭喜你，中奖了，将获得两件商品");
        machine.dispense();
        if(machine.getCount() == 0) {
            System.out.println("商品已经售罄");
            machine.setState(machine.getSoldOutState());
        }else {
            machine.dispense();
            if(machine.getCount() > 0) {
                machine.setState(machine.getNoMoneyState());
            }else {
                System.out.println("商品已经售罄");
                machine.setState(machine.getSoldOutState());
            }
        }
    }
}