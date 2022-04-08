package com.gs.common.web;

/**
 * @User远
 * @Date2022/4/8
 */
public class PageParam extends CallbackParam {

    private Integer page = 1;  // 当前第几页
    private Integer rows = 10; // 一页展示多少条数
    private Long total; // 总记录数

    public Integer getPage(){
        return page;
    }

    public void setPage(Integer page) {
        if(page < 1) page = 1;
        this.page = page;
    }

    public Integer getPageSize() {
        return rows;
    }

    public void setRows(Integer rows){
        if (rows < 1) rows = 1;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
