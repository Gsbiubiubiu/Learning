package com.gs.designmodel.chainofduty.special;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:38
 **/
public class WashHairFilter implements StudyPrepareFilter{
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if(preparationList.isWashHair()) {
            System.out.println("洗头");
        }
        filterChain.doFilter(preparationList, filterChain);
    }
}