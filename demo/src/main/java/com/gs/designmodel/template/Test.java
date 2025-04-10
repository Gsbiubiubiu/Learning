package com.gs.designmodel.template;

/**
 * @author: Gaos
 * @Date: 2023-06-27 10:48
 **/
public class Test {
    public static void main(String[] args) {
        Worker it1 = new ITWorker("程序猿1");
        it1.workOneDay();
        Worker it2 = new ITWorker("程序猿2");
        it2.workOneDay();

        Worker hr = new HRWorker("HR");
        hr.workOneDay();

        Worker test = new HRWorker("test");
        test.workOneDay();
    }
}