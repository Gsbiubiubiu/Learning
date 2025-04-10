package com.gs.designmodel.chainofduty.normal;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:28
 **/
public class EatBreakfastFilter extends AbstractPrepareFilter{

    public EatBreakfastFilter(AbstractPrepareFilter next) {
        super(next);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isHaveBreakfast()) {
            System.out.println("吃早餐");
        }
    }
}