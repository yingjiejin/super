package com.supermarket.domain.base;

import com.google.gson.Gson;

import javax.persistence.Transient;

/**
 * Created by Administrator on 2017/4/30.
 */
public class BaseEntity {

    @Transient
    private transient Integer page = 1;

    @Transient
    private transient Integer rows = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
