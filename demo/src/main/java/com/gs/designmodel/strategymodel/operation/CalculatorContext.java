package com.gs.designmodel.strategymodel.operation;

/**
 * @author: Gaos
 * @Date: 2022-11-23 16:41
 *  最后在定义一个环境角色，提供一个计算的接口供客户端使用。
 **/
public class CalculatorContext {
    private CalculateStrategy calculateStrategy;

    public CalculatorContext(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public int executeStrategy(int num1, int num2) {
        return calculateStrategy.doOperation(num1, num2);
    }

    // 测试
    public static void main(String[] args) {
        int a=4,b=2;
        // 这边其实也可以与简易工厂模式相结合
        CalculatorContext context = new CalculatorContext(new OperationAdd());
        System.out.println("a + b = "+context.executeStrategy(a, b));

        CalculatorContext context2 = new CalculatorContext(new OperationSub());
        System.out.println("a - b = "+context2.executeStrategy(a, b));

        CalculatorContext context3 = new CalculatorContext(new OperationMul());
        System.out.println("a * b = "+context3.executeStrategy(a, b));

        CalculatorContext context4 = new CalculatorContext(new OperationDiv());
        System.out.println("a / b = "+context4.executeStrategy(a, b));
    }
}