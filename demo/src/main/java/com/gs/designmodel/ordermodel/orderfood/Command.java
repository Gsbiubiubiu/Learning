package com.gs.designmodel.ordermodel.orderfood;

/**
 * @author: Gaos
 * @Date: 2023-01-16 13:55
 *
 * 抽象命令类
 *
 **/
public interface Command {
    /**
     * 命令执行方法
     */
    void execute();

    /**
     * 命令记录
     */
    void undo();
}