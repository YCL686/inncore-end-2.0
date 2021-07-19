package com.inncore.beta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inncore.beta.entity.SysRolePermission;
import com.inncore.beta.mapper.SysRolePermissionMapper;
import com.inncore.beta.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * (SysRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2020-09-23 16:14:39
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

}
