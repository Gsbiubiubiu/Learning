package com.gs.designmodel.daili.jingtai;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:12
 *
 *  诉讼接口
 **/
public interface ILawSuit {

    /**
     * 提起诉讼
     */
    void submit(String proof);

    /**
     * 法律辩护
     */
    void defend();
}