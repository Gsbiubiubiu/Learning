package com.gs.designmodel.template;

/**
 * @author: Gaos
 * @Date: 2023-06-27 10:32
 **/

import java.util.Date;

/**
 * 在父类中我们已经定义了一个上班算法的骨架，包含以下内容
 * 1、进入公司
 * 2、打开电脑
 * 3、上班情况
 * 4、关闭电脑
 * 5、离开公司
 *
 * 其中我们在父类中已经实现了1、2、4、5方法，子类中仅需要实现work这一个抽象方法
 * 来记录每天的工作情况即可
 */
public abstract class Worker {

    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    /**
     * 记录一天的工作
     */

    public final void workOneDay() {
        System.out.println("-----------work start------------");
        enterCompany();
        computerOn();
        work();
        computerOff();
        exitCompany();
        System.out.println("------------work end------------");
    }

    /**
     * 工作
     */
    public abstract void work();

    private void computerOff(){
        System.out.println(name + "关闭电脑");
    }

    private void computerOn() {
        System.out.println(name + "打开电脑");
    }

    private void enterCompany() {
        System.out.println(name + "进入公司");
    }

    private void exitCompany() {
        if(isNeedPrintDate()) {
            System.out.println(new Date() + "--->");
        }
        System.out.println(name + "离开公司");
    }

    public boolean isNeedPrintDate(){
        return false;
    }
}