package com.gs.designmodel.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-25 11:38
 **/
public class MisCompany {

    private List<CorporateSlave> employee = new ArrayList<>();

    public MisCompany() {
        employee.add(new Programmer("程序员"));
        employee.add(new Hr("Hr"));
        employee.add(new Tester("测试"));
    }

    public void startProject(CorporateSlaveVisitor visitor) {
        employee.forEach(x->{
            x.accept(visitor);
        });
    }
}