package com.ymm.microservices.usercenter.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * (SysRolePermission)表实体类
 *
 * @author makejava
 * @since 2020-09-23 16:14:39
 */

public class SysRolePermission extends Model<SysRolePermission> {

    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private Integer deleted;

    private Date createdTime;

    private Date updatedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
