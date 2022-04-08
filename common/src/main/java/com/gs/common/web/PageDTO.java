package com.gs.common.web;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @User远
 * @Date2022/4/7
 */
@Data
public class PageDTO<T> extends PageParam{
    private List<T> rows;

    public static <T> PageDTO<T> getEmpty() {
        PageDTO<T> pageDTO = new PageDTO<>();
        pageDTO.setTotal(0L);
        pageDTO.setPage(1);
        pageDTO.setRows(Collections.emptyList());
        return pageDTO;
    }

    public static <T> PageDTO<T> create(List<T> data, long total, int page, int pageSize){
        PageDTO<T> pageDTO = new PageDTO<>();
        pageDTO.setTotal(total);
        pageDTO.setPage(page);
        pageDTO.setRows(data);
        pageDTO.setRows(pageSize);
        return pageDTO;
    }

    public static <T> PageDTO<T> create(List<T> data, long total, Integer page, Integer pageSize){
        PageDTO<T> pageDTO = new PageDTO<>();
        pageDTO.setTotal(total);
        pageDTO.setPage(page);
        pageDTO.setRows(data);
        pageDTO.setRows(pageSize);
        return pageDTO;
    }

    public static <T> PageDTO<T> create(List<T> data, long total, PageParam page) {
        return create(data, total, page.getPage(), page.getPageSize());
    }
    // TODO 待看
    public static <T> PageDTO<T> createBeforeLimit(List<T> data, PageParam page){
        List<T> resultList = limit(data, page);
        return create(resultList, data.size(), page.getPage(), page.getPageSize());
    }

    public static <T> List<T> limit(List<T> data, PageParam page) {
        List<T> resultList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(data)){
            int indexStart = (page.getPage() - 1) * page.getPageSize();
            if(data.size() > indexStart){
                int indexEnd = Math.min(data.size(), page.getPage() * page.getPageSize());
                resultList = data.subList(indexStart, indexEnd);
            }
        }
        return resultList;
    }
}
