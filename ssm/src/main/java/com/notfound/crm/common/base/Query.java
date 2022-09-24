package com.notfound.crm.common.base;

/**
 * @Description:    这是查询基类，包括有分页条件，模糊查询关键字，模糊查询类型种类
 */
public class Query {
    /**
     * 当前页码，默认为1
     */
    private Integer currentPage = 1;
    /**
     * 每页显示条数，默认为10
     */
    private Integer pageSize = 100;
    /**
     * 从那一条数据开始查询
     */
    private Integer start;

    /**
     * 模糊查询关键字
     */
    private String keyword;
    /**
     * 模糊查询类型种类
     */
    private Integer type;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if(currentPage<=0){
            this.currentPage = 1;
        }else {
            this.currentPage = currentPage;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize<=0){
            this.pageSize = 5;
        }else {
            this.pageSize = pageSize;
        }
    }

    public Integer getStart() {
        return (currentPage-1)*pageSize;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Query{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", keyword='" + keyword + '\'' +
                ", type=" + type +
                '}';
    }
}
