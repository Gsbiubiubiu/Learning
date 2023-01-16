package com.gs.designmodel.adaptermodel;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Gaos
 * @Date: 2023-01-11 16:42
 * 需要一个适配器完成 220v->5v的作用
 **/
@Slf4j
public class V5PowerAdapter implements V5Power{

    /**
     * 使用组合的方式
     */
    private V220Power v220Power;

    /**
     * 提供构造方法
     * @param v220Power
     */
    public V5PowerAdapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    @Override
    public int provideV5Power() {
        int i = v220Power.provide220Power();
        // 经过一系列的转换操作
        log.info("适配器：经过一系列的转换操作 我将{}V电压转换为了 5V", i);
        return 5;
    }

    public static void main(String[] args) {
        // 测试
        Mobile mobile = new Mobile();
        V5PowerAdapter v5PowerAdapter = new V5PowerAdapter(new V220Power());
        mobile.inputPower(v5PowerAdapter);
    }
}