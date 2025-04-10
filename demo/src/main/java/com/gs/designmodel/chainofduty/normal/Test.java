package com.gs.designmodel.chainofduty.normal;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:28
 **/
public class Test {
    public static void main(String[] args) {
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(false);
        preparationList.setHaveBreakfast(true);

        Study study = new Study();
        AbstractPrepareFilter haveBreakfastFilter = new EatBreakfastFilter(null);
        AbstractPrepareFilter washFaceFilter = new WashFaceFilter(haveBreakfastFilter);
        AbstractPrepareFilter washHairFilter = new WashHairFilter(washFaceFilter);

        washHairFilter.doFilter(preparationList, study);
    }
}