package com.notfound.crm.common.base;

import com.notfound.crm.sys.vo.EmployeeVO;

import java.util.List;

/**
 * @Description: 分页信息包装类
 */
public class PageInfo {

    /**
     * 页码
     */
    private Integer page;
    /**
     * 一页限制条数
     */
    private Integer limit;
    /**
     * 数据总条数
     */
    private Long count;
    /**
     * 符合条件的数据集合
     */
    private List<Object> data;

//    public PageInfo(){}

    public PageInfo(Integer page, Integer limit, Long count, List<Object> data) {
        this.page = page;
        this.limit = limit;
        this.count = count;
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", limit=" + limit +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
