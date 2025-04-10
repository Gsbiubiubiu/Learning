package com.gs.designmodel.state.real;

/**
 * @author: Gaos
 * @Date: 2023-07-17 10:33
 *
 * 准备出商品的状态
 **/
public class SoldState implements State{

    private VendingMachine machine;

    public SoldState(VendingMachine machine) {
        this.machine = machine;
    }


    @Override
    public void insertMoney() {
        System.out.println("正在出货中，请勿投币");
    }

    @Override
    public void backMoney() {
        System.out.println("正在出货中，无币可退");
    }

    @Override
    public void turnCrank() {
        System.out.println("正在出货中，请勿转动手柄");
    }

    @Override
    public void dispense() {
        machine.dispense();
        if(machine.getCount() > 0) {
            machine.setState(machine.getNoMoneyState());
        }else {
            System.out.println("商品已售罄");
            machine.setState(machine.getSoldOutState());
        }
    }
}