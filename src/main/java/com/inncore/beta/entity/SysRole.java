package com.inncore.beta.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 系统角色表(SysRole)表实体类
 *
 * @author makejava
 * @since 2020-08-05 16:10:19
 */

public class SysRole extends Model<SysRole> {
    //角色主键
    private Integer id;
    //角色名称
    private String roleName;
    //角色标识
    private String roleCode;
    //角色描述
    private String roleDesc;
    //创建时间
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date createdTime;
    //更新时间
    @JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
    //删除标识（0-正常,1-删除）
    @JsonIgnore
    private Integer deleted;
    //数据权限类型
    private Integer dsType;
    //数据权限范围 1 全部 2 本级 3 本级以及子级 4 自定义
    private String dsScope;
    //租户id
    private String tenantId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDsType() {
        return dsType;
    }

    public void setDsType(Integer dsType) {
        this.dsType = dsType;
    }

    public String getDsScope() {
        return dsScope;
    }

    public void setDsScope(String dsScope) {
        this.dsScope = dsScope;
    }

    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
