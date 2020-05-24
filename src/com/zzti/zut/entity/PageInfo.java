package com.zzti.zut.entity;

public class PageInfo {
    private int pageNum;
    private int offset;

    public PageInfo() {
    }

    public PageInfo(int pageNum, int offset) {
        this.pageNum = pageNum;
        this.offset = offset;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
