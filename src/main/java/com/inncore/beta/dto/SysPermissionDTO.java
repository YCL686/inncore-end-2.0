package com.inncore.beta.dto;

import com.inncore.beta.entity.SysPermission;
import com.inncore.beta.entity.SysRole;

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
