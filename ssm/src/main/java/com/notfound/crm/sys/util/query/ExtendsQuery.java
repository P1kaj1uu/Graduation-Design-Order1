package com.notfound.crm.sys.util.query;

import com.notfound.crm.common.base.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description 新增时间查询功能
 */
public class ExtendsQuery extends Query {
    /**
     * 查询的开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    /**
     * 查询的结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 员工身份标识
     */
    private Integer self;

    /***
     *分组条件
     */
    private String groupTypeStr;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSelf() {
        return self;
    }

    public void setSelf(Integer self) {
        this.self = self;
    }

    public String getGroupTypeStr() {
        return groupTypeStr;
    }

    public void setGroupTypeStr(String groupTypeStr) {
        this.groupTypeStr = groupTypeStr;
    }

    @Override
    public String toString() {
        return "ExtendsQuery{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", self=" + self +
                ", groupTypeStr='" + groupTypeStr + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
