package com.inncore.beta.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 部门管理(SysDept)表实体类
 *
 * @author makejava
 * @since 2020-08-05 16:14:58
 */

public class SysDept extends Model<SysDept> {
    //部门主键ID
    private Integer id;
    //部门名称
    private String name;
    //排序
    private Integer sort;
    //创建时间
    @JsonIgnore
    private Date createdTime;
    //修改时间
    @JsonIgnore
    private Date updatedTime;
    //是否删除  -1：已删除  0：正常
    private Integer deleted;
    //上级部门
    private Integer parentId;
    //租户id
    private String tenantId;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
