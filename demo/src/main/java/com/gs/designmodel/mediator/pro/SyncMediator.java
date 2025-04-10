package com.gs.designmodel.mediator.pro;

/**
 * @author: Gaos
 * @Date: 2023-08-21 17:34
 **/
public class SyncMediator extends AbstractMediator{

    @Override
    public void sync(String databaseName, String data) {
        if(AbstractDatabase.MYSQL.equals(databaseName)) {
            // mysql需要同步到 redis和es
            this.redisDatabase.addData(data);
            this.esDatabase.addData(data);
        }else if(AbstractDatabase.REDIS.equals(databaseName)) {
            // 无须同步
        }else if(AbstractDatabase.ELASTICSEARCH.equals(databaseName)) {
            // es需要同步到 mysql
            this.mysqlDatabase.addData(data);
        }
    }
}