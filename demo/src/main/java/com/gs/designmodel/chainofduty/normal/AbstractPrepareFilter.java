package com.gs.designmodel.chainofduty.normal;

import com.gs.designmodel.chainofduty.bad.PreparationList;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:21
 **/
public abstract class AbstractPrepareFilter {

    private AbstractPrepareFilter next;

    public AbstractPrepareFilter(AbstractPrepareFilter next) {
        this.next = next;
    }

    public void doFilter(PreparationList preparationList, Study study) {
        prepare(preparationList);
        if(next == null) {
            study.study();
        }else {
            next.doFilter(preparationList, study);
        }
    }

    public abstract void prepare(PreparationList preparationList);
}