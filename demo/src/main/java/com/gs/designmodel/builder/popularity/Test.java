package com.gs.designmodel.builder.popularity;


/**
 * @author: Gaos
 * @Date: 2023-07-20 11:35
 **/
public class Test {
    public static void main(String[] args) {
        Computer computer=new Computer.Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer);
    }
}