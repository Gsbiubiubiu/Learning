package com.gs.designmodel.strategymodel.operation;

/**
 * @author: Gaos
 * @Date: 2022-11-23 16:39
 **/
public class OperationSub implements CalculateStrategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}