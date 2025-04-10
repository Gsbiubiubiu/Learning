package com.gs.designmodel.builder.tradition;

/**
 * @author: Gaos
 * @Date: 2023-07-19 16:50
 **/
public class LenovoComputerBuilder extends ComputerBuilder{

    private Computer computer;

    public LenovoComputerBuilder(String cpu, String ram) {
        computer = new Computer(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(4);
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyBoard("Lenovo键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("Lenovo显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}