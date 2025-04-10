package com.gs.designmodel.builder.tradition;

/**
 * @author: Gaos
 * @Date: 2023-07-19 16:46
 *
 * 抽象构建者类
 **/
public abstract class ComputerBuilder {

    public abstract void setUsbCount();

    public abstract void setKeyBoard();

    public abstract void setDisplay();

    public abstract Computer getComputer();
}