package com.gs.designmodel.builder.tradition;

/**
 * @author: Gaos
 * @Date: 2023-07-19 16:37
 *
 * 目标电脑类
 **/
public class Computer {

    private String cpu; // 必选

    private String ram;// 必选

    private int usbCount;

    private String keyBoard;

    private String display;

    public Computer(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usbCount=" + usbCount +
                ", keyBoard='" + keyBoard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}