package com.notfound.crm.sys.form;

import com.notfound.crm.sys.domain.Employee;
import com.notfound.crm.sys.domain.Permissions;
import com.notfound.crm.sys.domain.Role;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;


public class RoleForm extends Role {
    /**
     * 角色id
     */
    private Integer id;
    /**
     * 角色编号
     */
    @NotBlank(message = "角色编号不能为空！")
    private String sn;
    /**
     * 角色姓名
     */
    @NotBlank(message = "角色姓名不能为空！")
    private String name;
    /**
     * 权限关系连接
     */
    private String permission;
    /**
     * 员工表连接
     */
    private List<Employee> employeeList = new ArrayList<>();
    /**
     * 权限表连接
     */
    private List<Permissions> permissionsList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    @Override
    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Permissions> getPermissionsList() {
        return permissionsList;
    }

    public void setPermissionsList(List<Permissions> permissionsList) {
        this.permissionsList = permissionsList;
    }
}
