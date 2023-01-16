package com.gs.designmodel.adaptermodel;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Gaos
 * @Date: 2023-01-11 16:29
 * 首先使用一部手机
 **/
@Slf4j
public class Mobile {

    /**
     * 充电
     * @param power 需要一个5v的充电器
     */
    public void inputPower(V5Power power) {
        int provideV5Power = power.provideV5Power();
        log.info("手机（客户端）：我需要一个5v电压充电，现在是——————》{}", provideV5Power);
    }
}