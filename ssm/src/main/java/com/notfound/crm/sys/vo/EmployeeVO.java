package com.notfound.crm.sys.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.notfound.crm.sys.domain.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 用于接收查询到的数据
 */
@Data
@ColumnWidth(20)
public class EmployeeVO{
    /**
     * ID
     */
    @ExcelIgnore
    private Integer id;

    /**
     * 员工姓名
     */
    @ExcelProperty(value = "员工姓名")
    private String name;

    /**
     * 密码
     */
    @ExcelProperty(value = "密码")
    @ColumnWidth(20)
    private String password;

    /**
     * 邮箱
     */
    @ColumnWidth(25)
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 年龄
     */
    @ExcelProperty(value = "年龄")
    private Integer age;

    /**
     * 部门
     */
    @ExcelProperty(value = "部门")
    private String dept;

    /**
     * 入职日期
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "入职日期")
    @DateTimeFormat("yyyy-MM-dd")
    private Date hiredate;

    /**
     * 入职时间：1 正常，0 离职
     */
    @ExcelProperty(value = "状态")
    private Integer state;

    /**
     * 超级管理员身份：1 超级管理员，0普通员工
     */
    @ExcelProperty(value = "是否超级管理员")
    private Integer admin;

    /**
     * 角色
     */
    @ExcelProperty(value = "角色")
    private String role;

    /**
     * 角色多对多关系连接
     */
    @ExcelIgnore
    private List<Role> roleList = new ArrayList<>();
    /**
     * 部门名称
     */
    @ExcelIgnore
    private String dname;
    /**
     * 角色名称
     */
    @ExcelIgnore
    private String rname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
