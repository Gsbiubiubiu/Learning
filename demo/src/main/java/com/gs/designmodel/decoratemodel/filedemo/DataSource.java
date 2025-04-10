package com.gs.designmodel.decoratemodel.filedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-17 13:56
 * 装饰模式：
 *  定义了读取和写入操作的通用数据接口
 **/
public interface DataSource{

    /**
     * 写数据
     * @param data
     */
    void writeData(String data);

    /**
     * 读数据
     * @return
     */
    String readData();
}