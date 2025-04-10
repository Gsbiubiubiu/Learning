package com.gs.designmodel.chainofduty.special;

import com.gs.designmodel.chainofduty.bad.PreparationList;


/**
 * @author: Gaos
 * @Date: 2023-08-28 20:30
 **/
public interface StudyPrepareFilter {

    public void doFilter(PreparationList preparationList, FilterChain filterChain);
}
