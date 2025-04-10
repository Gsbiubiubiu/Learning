package com.gs.designmodel.mediator.pro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-21 17:21
 *
 * 具体同事类->mysql
 **/
public class MysqlDatabase extends AbstractDatabase{

    private List<String> dataset = new ArrayList<>();

    public MysqlDatabase(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("Mysql 添加数据" + data);
        this.dataset.add(data);
    }

    /**
     * 数据同步作业交给中介者管理，这里无须关心
     * @param data
     */
    @Override
    public void sync(String data) {
        addData(data);
        this.mediator.sync(AbstractDatabase.MYSQL, data);
    }

    public void select() {
        System.out.println("Mysql 查询数据" + this.dataset.toString());
    }
}