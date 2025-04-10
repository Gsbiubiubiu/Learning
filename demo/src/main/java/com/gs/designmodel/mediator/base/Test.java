package com.gs.designmodel.mediator.base;

/**
 * @author: Gaos
 * @Date: 2023-08-21 17:04
 **/
public class Test {
    public static void main(String[] args) {
        MysqlDatabase mysqlDatabase = new MysqlDatabase();
        RedisDatabase redisDatabase = new RedisDatabase();
        EsDatabase esDatabase = new EsDatabase();

        mysqlDatabase.setRedisDatabase(redisDatabase);
        mysqlDatabase.setEsDatabase(esDatabase);
        esDatabase.setMysqlDatabase(mysqlDatabase);

        System.out.println("----mysql 添加数据 mysqlA 需要同步到另外两个数据库中----");
        mysqlDatabase.sync("mysqlA");

        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("----Redis 添加数据 redisB 无须同步到其他数据库----");
        redisDatabase.sync("redisB");

        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("----Es 添加数据 esC 需要同步到Mysql中");
        esDatabase.sync("esC");

        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();
    }
}