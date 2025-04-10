package com.gs.designmodel.mediator.base;

/**
 * @author: Gaos
 * @Date: 2023-08-21 16:47
 *
 * 抽象数据库
 **/
public abstract class AbstractDatabase {

    public abstract void sync(String data);

    public abstract void addData(String data);
}