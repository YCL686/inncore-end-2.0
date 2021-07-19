package com.inncore.beta.dto;

import com.inncore.beta.entity.SysMenu;
import com.inncore.beta.entity.SysRole;

import java.util.List;


public class SysMenuDTO extends SysMenu {

    //    public SysMenuDTO(SysMenu menu) {
//        super(menu);
//    }
    private List<SysRole> roles;
    public SysMenuDTO() {
    }

    private String parentTitle;
    private Integer childNum;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }
}
