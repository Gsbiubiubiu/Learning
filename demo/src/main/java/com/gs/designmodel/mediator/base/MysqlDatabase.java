package com.gs.designmodel.mediator.base;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-21 16:50
 *
 * 具体数据库--mysql 需要维护同步到redis、es的任务
 **/
public class MysqlDatabase extends AbstractDatabase{

    private List<String> dataset = new ArrayList<>();

    @Setter
    private RedisDatabase redisDatabase;

    @Setter
    private EsDatabase esDatabase;

    /**
     * 需要维护同步到Es、redis的数据同步任务
     * @param data
     */
    @Override
    public void sync(String data) {
      addData(data);
      redisDatabase.addData(data);
      esDatabase.addData(data);
    }

    @Override
    public void addData(String data) {
        System.out.println("Mysql 添加数据" + data);
        this.dataset.add(data);
    }

    public void select() {
        System.out.println("Mysql 查询数据" + this.dataset.toString());
    }
}