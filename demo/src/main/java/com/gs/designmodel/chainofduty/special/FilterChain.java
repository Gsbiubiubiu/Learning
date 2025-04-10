package com.gs.designmodel.chainofduty.special;

import com.gs.designmodel.chainofduty.bad.PreparationList;
import com.gs.designmodel.chainofduty.normal.Study;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:32
 **/
public class FilterChain implements StudyPrepareFilter{

    private int pos = 0;

    private Study study;

    private List<StudyPrepareFilter> studyPrepareFilters;

    public FilterChain(Study study) {
        this.study = study;
    }

    public void addFilter(StudyPrepareFilter studyPrepareFilter) {
        if(studyPrepareFilters == null) {
            studyPrepareFilters = new ArrayList<>();
        }
        studyPrepareFilters.add(studyPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        // 所有过滤器已经执行完毕
        if(pos == studyPrepareFilters.size()) {
            study.study();
        }else {
            studyPrepareFilters.get(pos++).doFilter(preparationList, filterChain);
        }

    }
}