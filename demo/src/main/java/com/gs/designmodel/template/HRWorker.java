package com.gs.designmodel.template;

/**
 * @author: Gaos
 * @Date: 2023-06-27 10:42
 **/

/**
 * HR
 */
public class HRWorker extends Worker{
    public HRWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + "筛选简历-打电话");
    }
}