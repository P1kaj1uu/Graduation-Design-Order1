package com.notfound.crm.sys.form;

import com.notfound.crm.sys.domain.Role;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 用于接收更新user表数据的类,简单来说就是进行数据校验的，经过校验的数据才能插入数据库
 */
public class EmployeeForm{

    /**
     * ID
     */
    private Integer id;

    /**
     * 员工姓名
     */
    @NotBlank(message = "姓名不能为空！")
    private String name;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空！")
    private String password;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空！")
    @Email(message = "请输入正确的邮箱！")
    private String email;

    /**
     * 年龄
     */
    @NotNull
    @Min(15)
    @Max(100)
    private Integer age;

    /**
     * 部门
     */
    private String dept;

    /**
     * 入职日期
     */
    @Past(message = "入职日期必须是过去的日期！")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hiredate;

    /**
     * 入职时间：1 正常，0 离职
     */
    @Min(0)
    @Max(1)
    private Integer state;

    /**
     * 超级管理员身份：1 超级管理员，0普通员工
     */
    @Min(0)
    @Max(1)
    private Integer admin;

    /**
     * 角色name连接
     */
    @Min(1)
    @Max(2)
    private String role;

    /**
     * 角色多对多关系连接
     */
    private List<Role> roleList = new ArrayList<>();

    public EmployeeForm() {
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
