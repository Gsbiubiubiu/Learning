package com.gs.designmodel.state.real;

/**
 * @author: Gaos
 * @Date: 2023-07-17 10:04
 * 状态接口
 **/
public interface State {

    /**
     * 放钱
     */
    public void insertMoney();

    /**
     * 退钱
     */
    public void backMoney();

    /**
     * 转动曲柄
     */
    void turnCrank();

    /**
     * 售出商品
     */
    void dispense();
}
