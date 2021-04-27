package com.ymm.microservices.usercenter.dto;

import com.ymm.microservices.usercenter.entity.SysPermission;
import com.ymm.microservices.usercenter.entity.SysRole;

import java.util.List;


public class SysPermissionDTO extends SysPermission {
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
