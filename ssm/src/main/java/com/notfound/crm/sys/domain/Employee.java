package com.notfound.crm.sys.domain;


import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**

 * @Description: employee员工实体类
 */
public class Employee {
    /**
     * ID
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 部门
     */
    private String dept;

    /**
     * 入职日期
     */
    @DateTimeFormat("yyyy-MM-dd")
    private Date hiredate;

    /**
     * 入职时间：1 正常，0 离职
     */
    private Integer state;

    /**
     * 超级管理员身份：1 超级管理员，0普通员工
     */
    private Integer admin;

    /**
     * 角色
     */
    private String role;

    /**
     * 角色多对多关系连接
     */
    private List<Role> roleList = new ArrayList<>();

    public Employee() {
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

    public java.util.Date getHiredate() {
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", hiredate=" + hiredate +
                ", state=" + state +
                ", admin=" + admin +
                ", role='" + role + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}