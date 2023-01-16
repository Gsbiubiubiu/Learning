package com.gs.designmodel.strategymodel.operation;

/**
 * @author: Gaos
 * @Date: 2022-11-23 16:24
 *
 * 然后再定义加减乘除这些具体策略角色并实现方法。
 **/
public class OperationAdd implements CalculateStrategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}