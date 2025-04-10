package com.gs.designmodel.mediator.pro;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: Gaos
 * @Date: 2023-08-21 17:31
 **/
public class EsDatabase extends AbstractDatabase{

    private List<String> dataset = new CopyOnWriteArrayList<>();


    public EsDatabase(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("Es 添加数据" + data);
        this.dataset.add(data);
    }

    /**
     * 数据同步作业交给中介者管理，这里无须关心
     * @param data
     */
    @Override
    public void sync(String data) {
        addData(data);
        this.mediator.sync(AbstractDatabase.ELASTICSEARCH, data);
    }

    public void count() {
        System.out.println("Es统计目前共有" + this.dataset.size() + "条数据, 数据：" + this.dataset);
    }
}