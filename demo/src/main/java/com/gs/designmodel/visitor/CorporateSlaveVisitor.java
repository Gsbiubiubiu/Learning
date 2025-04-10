package com.gs.designmodel.visitor;

/**
 * @author: Gaos
 * @Date: 2023-08-25 10:31
 **/
public interface CorporateSlaveVisitor {

    void visit(Programmer programmer);

    void visit(Tester tester);

    void visit(Hr hr);
}
