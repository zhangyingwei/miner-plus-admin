package com.zhangyingwei.miner.common.Page;

/**
 * Created by zhangyw on 2017/8/22.
 */
public class PageInfo {
    private Integer size = 8;
    private Integer currentPage = 1;
    private Integer start = 0;
    private Integer total = 0;
    private Integer pages = 0;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getStart() {
        this.start = (this.currentPage - 1) * this.size;
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPages() {
        if(this.getTotal()%this.getSize() == 0){
            pages = this.getTotal() / this.getSize();
        }else{
            pages = this.getTotal() / this.getSize() + 1;
        }
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer limit(){
        return size;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "size=" + size +
                ", currentPage=" + currentPage +
                ", start=" + start +
                ", total=" + total +
                ", pages=" + pages +
                '}';
    }
}
