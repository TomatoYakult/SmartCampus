package com.zzti.zut.entity;

import java.util.ArrayList;
import java.util.List;

public class ReturnData<T> {
    private List<T> rows = new ArrayList<T>();
    private int total;

    public ReturnData() {
    }

    public ReturnData(List<T> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ReturnData{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
