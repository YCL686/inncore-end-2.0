package com.ymm.microservices.usercenter.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单权限表(SysRoute)表实体类
 *
 * @author makejava
 * @since 2020-08-27 09:38:19
 */

public class SysRoute extends Model<SysRoute> {
    //路由ID
    private Integer id;
    //路由名称
    private String name;
    //菜单权限标识
    private String perms;
    //前端跳转URL
    private String path;
    //路由组件
    private String component;
    //父路由ID
    private Integer parentId;

    //排序
    private Integer sort;
    //路由类型 （类型   0：目录   1：菜单   2：按钮）
    private Integer type;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date createdTime;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date updatedTime;
    //逻辑删除标记(0--正常 1--删除)
    @JsonIgnore
    private Integer deleted;
    //是否为外链


    private String title;
    private Integer hidden;
    private Integer hideChildren;
    private Integer hideHeaderContent;
    private String target;
    private String icon;
    private String tenantId;
    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
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

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Integer getHideChildren() {
        return hideChildren;
    }

    public void setHideChildren(Integer hideChildren) {
        this.hideChildren = hideChildren;
    }

    public Integer getHideHeaderContent() {
        return hideHeaderContent;
    }

    public void setHideHeaderContent(Integer hideHeaderContent) {
        this.hideHeaderContent = hideHeaderContent;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
