package com.gs.designmodel.daili.dongtai;

import com.gs.designmodel.daili.jingtai.ILawSuit;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:24
 *
 * 小华诉讼类
 **/
public class XiaoHua implements ILawSuit {
    @Override
    public void submit(String proof) {
        System.out.println("老板带着小姨子欠薪跑路了，证据如下: " + proof);
    }

    @Override
    public void defend() {
        System.out.println("审判结果，10号之前必须还钱");
    }
}