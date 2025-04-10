package com.gs.designmodel.mediator.pro;

/**
 * @author: Gaos
 * @Date: 2023-08-21 17:12
 *
 * 抽象数据库类(同事类)，维护一个中介者对象的引用
 **/
public abstract class AbstractDatabase {

    public static final String MYSQL = "mysql";

    public static final String REDIS = "redis";

    public static final String ELASTICSEARCH = "elasticsearch";

    protected AbstractMediator mediator;

    public AbstractDatabase(AbstractMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void addData(String data);

    public abstract void sync(String data);
}