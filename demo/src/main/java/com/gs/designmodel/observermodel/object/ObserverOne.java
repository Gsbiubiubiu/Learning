package com.gs.designmodel.observermodel.object;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Gaos
 * @Date: 2022-10-31 16:30
 *
 * 主题观察者1
 **/
@Slf4j
public class ObserverOne implements Observer{

    private Subject subject;

    public ObserverOne(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String message) {
      log.info("ObserverOne得到号码 {}, 已记录", message);
    }
}