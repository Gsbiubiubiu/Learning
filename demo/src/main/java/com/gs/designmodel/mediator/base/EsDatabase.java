package com.gs.designmodel.mediator.base;

import lombok.Setter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: Gaos
 * @Date: 2023-08-21 16:59
 *
 * Es数据库
 **/
public class EsDatabase extends AbstractDatabase{

    private List<String> dataset = new CopyOnWriteArrayList<>();

    @Setter
    private MysqlDatabase mysqlDatabase;

    /**
     * 需要维护同步到mysql的同步任务
     * @param data
     */
    @Override
    public void sync(String data) {
        addData(data);
        this.mysqlDatabase.addData(data);
    }

    @Override
    public void addData(String data) {
        System.out.println("Es 添加数据" + data);
        this.dataset.add(data);
    }

    public void count() {
        System.out.println("Es统计目前共有" + this.dataset.size() + "条数据, 数据：" + this.dataset);
    }
}