package com.gs.designmodel.visitor;

/**
 * @author: Gaos
 * @Date: 2023-08-25 11:49
 **/
public class SocialApp implements CorporateSlaveVisitor{
    @Override
    public void visit(Programmer programmer) {
        System.out.println("社交app" + programmer.getName());
    }

    @Override
    public void visit(Tester tester) {
        System.out.println("社交app" + tester.getName());
    }

    @Override
    public void visit(Hr hr) {
        System.out.println("社交app" + hr.getName());
    }
}