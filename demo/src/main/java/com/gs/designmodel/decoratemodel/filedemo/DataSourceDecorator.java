package com.gs.designmodel.decoratemodel.filedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-17 14:18
 *
 * 抽象基础装饰(实现通用数据接口，使其具有相同的规则)
 **/
public class DataSourceDecorator implements DataSource{

    /**
     * 持有其引用
     */
    private DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}