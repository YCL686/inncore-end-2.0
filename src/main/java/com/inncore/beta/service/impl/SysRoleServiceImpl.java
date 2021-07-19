package com.inncore.beta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inncore.beta.entity.SysRole;
import com.inncore.beta.mapper.SysRoleMapper;
import com.inncore.beta.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 系统角色表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 16:10:19
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

}
