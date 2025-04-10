package com.gs.designmodel.chainofduty.normal;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:25
 **/
public class WashFaceFilter extends AbstractPrepareFilter{

    public WashFaceFilter(AbstractPrepareFilter next) {
        super(next);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isWashFace()) {
            System.out.println("洗脸");
        }
    }
}