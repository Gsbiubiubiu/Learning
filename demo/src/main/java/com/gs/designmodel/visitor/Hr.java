package com.gs.designmodel.visitor;

/**
 * @author: Gaos
 * @Date: 2023-08-25 11:31
 *
 * Hrbp
 **/
public class Hr implements CorporateSlave{

    private String name;

    public Hr(String name) {
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