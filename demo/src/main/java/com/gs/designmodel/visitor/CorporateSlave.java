package com.gs.designmodel.visitor;

/**
 * @author: Gaos
 * @Date: 2023-08-25 10:33
 *
 * 打工人类
 **/
public interface CorporateSlave {
    void accept(CorporateSlaveVisitor visitor);
}
