package com.gs.designmodel.chainofduty.special;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:37
 **/
public class WashFaceFilter implements StudyPrepareFilter{
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if(preparationList.isWashFace()) {
            System.out.println("洗脸");
        }
        filterChain.doFilter(preparationList, filterChain);
    }
}