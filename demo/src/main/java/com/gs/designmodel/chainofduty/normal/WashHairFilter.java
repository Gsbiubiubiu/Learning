package com.gs.designmodel.chainofduty.normal;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:27
 **/
public class WashHairFilter extends AbstractPrepareFilter{

    public WashHairFilter(AbstractPrepareFilter next) {
        super(next);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isWashHair()) {
            System.out.println("洗头");
        }
    }
}