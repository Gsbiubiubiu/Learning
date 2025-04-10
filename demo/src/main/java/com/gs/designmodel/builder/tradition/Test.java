package com.gs.designmodel.builder.tradition;

/**
 * @author: Gaos
 * @Date: 2023-07-19 16:57
 *
 * 首先生成一个director->生成一个目标builder->使用director组装builder->组装完毕后创建产品实例
 **/
public class Test {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        MacComputerBuilder builder = new MacComputerBuilder("I5处理器", "三星122");

        director.makeComputer(builder);

        Computer macComputer = builder.getComputer();
        System.out.println("mac computer :" + macComputer.toString());

        LenovoComputerBuilder lenovoBuilder = new LenovoComputerBuilder("I7处理器", "海尔155");
        director.makeComputer(lenovoBuilder);
        Computer lenovoComputer = lenovoBuilder.getComputer();
        System.out.println("lenovo computer: " + lenovoComputer.toString());

    }
}