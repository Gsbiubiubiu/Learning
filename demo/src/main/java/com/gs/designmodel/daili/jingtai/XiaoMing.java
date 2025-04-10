package com.gs.designmodel.daili.jingtai;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:15
 *
 * 小明诉讼类型
 **/

public class XiaoMing implements ILawSuit{

    @Override
    public void submit(String proof) {
        System.out.println("老板带着小姨子欠薪跑路了，证据如下: " + proof);
    }

    @Override
    public void defend() {
        System.out.println("审判结果，必须还钱");
    }
}