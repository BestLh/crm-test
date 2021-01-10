package com.sm.cn.vo;

import java.util.List;

public class PageVo<T> {
    private long total;
    private List<T> list;

    public PageVo(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public PageVo() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
