package com.gs.designmodel.visitor;

/**
 * @author: Gaos
 * @Date: 2023-08-25 11:29
 *
 * 测试
 **/
public class Tester implements CorporateSlave{

    private String name;

    public Tester(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(CorporateSlaveVisitor visitor) {
        visitor.visit(this);
    }
}