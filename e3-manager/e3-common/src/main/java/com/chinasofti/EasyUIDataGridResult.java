package com.chinasofti;

import java.util.List;
/**
 * author:胡瑶
 * date:2019/4/24
 * time:18:53
 */
public class EasyUIDataGridResult {

    private Integer total;

    private List<?> rows;

    public EasyUIDataGridResult(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public EasyUIDataGridResult(Long total, List<?> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}