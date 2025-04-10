package com.gs.designmodel.visitor;

/**
 * @author: Gaos
 * @Date: 2023-08-25 11:50
 **/
public class LiveApp implements CorporateSlaveVisitor{
    @Override
    public void visit(Programmer programmer) {
        System.out.println("直播app" + programmer.getName());
    }

    @Override
    public void visit(Tester tester) {
        System.out.println("直播app" + tester.getName());
    }

    @Override
    public void visit(Hr hr) {
        System.out.println("直播app" + hr.getName());
    }
}