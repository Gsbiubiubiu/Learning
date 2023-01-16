package com.gs.designmodel.observermodel.util;

import java.util.Observable;

/**
 * @author: Gaos
 * @Date: 2022-10-31 23:57
 *
 *  由JDK.util工具包实现的观察者模式
 *
 *  3D彩票服务号主题
 **/
public class SubjectFor3D extends Observable {

    private String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers();
    }
}