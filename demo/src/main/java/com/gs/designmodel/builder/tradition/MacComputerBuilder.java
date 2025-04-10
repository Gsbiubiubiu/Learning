package com.gs.designmodel.builder.tradition;

/**
 * @author: Gaos
 * @Date: 2023-07-19 16:47
 *
 * 苹果电脑构建者类
 **/
public class MacComputerBuilder extends ComputerBuilder{

    private Computer computer;

    public MacComputerBuilder(String cpu, String ram) {
        computer = new Computer(cpu, ram);
    }

    @Override
    public void setUsbCount() {
        computer.setUsbCount(2);
    }

    @Override
    public void setKeyBoard() {
        computer.setKeyBoard("Mac键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("Mac显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}