package com.gs.designmodel.template;

/**
 * @author: Gaos
 * @Date: 2023-06-27 10:43
 **/

/**
 * 测试人员
 */
public class TestWorker extends Worker{

    public TestWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + "编写测试用例-测试系统");
    }
}