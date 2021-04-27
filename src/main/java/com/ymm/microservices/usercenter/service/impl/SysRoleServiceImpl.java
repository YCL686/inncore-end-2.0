package com.ymm.microservices.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymm.microservices.usercenter.entity.SysRole;
import com.ymm.microservices.usercenter.mapper.SysRoleMapper;
import com.ymm.microservices.usercenter.service.SysRoleService;
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
