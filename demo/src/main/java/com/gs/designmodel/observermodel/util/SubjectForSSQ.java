package com.gs.designmodel.observermodel.util;

import java.util.Observable;

/**
 * @author: Gaos
 * @Date: 2022-11-01 00:03
 *
 * 双色球服务号主题
 **/
public class SubjectForSSQ extends Observable {

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