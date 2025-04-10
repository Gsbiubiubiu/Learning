package com.gs.designmodel.mediator.pro;

import lombok.Data;

/**
 * @author: Gaos
 * @Date: 2023-08-21 17:19
 **/
@Data
public abstract class AbstractMediator {

    protected MysqlDatabase mysqlDatabase;

    protected RedisDatabase redisDatabase;

    protected EsDatabase esDatabase;

    public abstract void sync(String databaseName, String data);
}