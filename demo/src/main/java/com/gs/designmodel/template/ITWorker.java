package com.gs.designmodel.template;

/**
 * @author: Gaos
 * @Date: 2023-06-27 10:37
 **/

/**
 * 程序猿
 */
public class ITWorker extends Worker{



    public ITWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + "写程序-联调-修改bug");
    }

    @Override
    public boolean isNeedPrintDate() {
        return Boolean.TRUE;
    }

}