package com.gs.designmodel.observermodel.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2022-10-31 16:23
 **/
public class ObjectFor3D implements Subject{

    /**
     * 订阅的观察者集合
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * 3D彩票的号码
     */
    private String message;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer item : observers) {
            item.update(message);
        }
    }

    /**
     * 主题更新消息
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}