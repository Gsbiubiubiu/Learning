package com.gs.designmodel.observermodel.object;

/**
 * @author: Gaos
 * @Date: 2022-10-31 16:19
 *
 * 所有的观察者，都需要实现此接口, java.util 中提供的有此接口
 **/
public interface Observer {

    /**
     * todo:
     * @param message
     */
    public void update(String message);
}
