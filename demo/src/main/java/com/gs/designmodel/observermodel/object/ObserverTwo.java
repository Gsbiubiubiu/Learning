package com.gs.designmodel.observermodel.object;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Gaos
 * @Date: 2022-10-31 16:35
 *
 * 主题观察者2
 **/
@Slf4j
public class ObserverTwo implements Observer{
    private Subject subject;

    public ObserverTwo(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String message) {
        log.info("ObserverTwo得到号码 {}, 已记录", message);
    }
}