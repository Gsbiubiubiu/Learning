package com.gs.designmodel.mediator.base;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-21 16:56
 **/
public class RedisDatabase extends AbstractDatabase{

    private List<String> dataset = new LinkedList<>();

    /**
     * 不需要同步到其他数据库
     * @param data
     */
    @Override
    public void sync(String data) {
        addData(data);
    }

    @Override
    public void addData(String data) {
        System.out.println("Redis 添加数据 " + data);
        this.dataset.add(data);
    }

    public void cache() {
        System.out.println("Redis 缓存的数据" + this.dataset.toString());
    }
}