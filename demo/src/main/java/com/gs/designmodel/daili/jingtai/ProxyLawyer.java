package com.gs.designmodel.daili.jingtai;

/**
 * @author: Gaos
 * @Date: 2023-08-07 10:19
 *
 * 代理律师诉讼类
 **/
public class ProxyLawyer implements ILawSuit{

    /**
     * 需要代理的对象
     */
    private ILawSuit plaintiff;

    public ProxyLawyer(ILawSuit plaintiff) {
        this.plaintiff = plaintiff;
    }

    @Override
    public void submit(String proof) {
        plaintiff.submit(proof);
    }

    @Override
    public void defend() {
        plaintiff.defend();
    }
}