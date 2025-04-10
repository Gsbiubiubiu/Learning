package com.gs.designmodel.chainofduty.special;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:39
 **/
public class EatBreakfastFilter implements StudyPrepareFilter{
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if(preparationList.isHaveBreakfast()) {
            System.out.println("吃完早饭");
        }
        filterChain.doFilter(preparationList, filterChain);
    }
}