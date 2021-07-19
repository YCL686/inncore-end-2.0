package com.inncore.beta.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inncore.beta.dto.SysUserDTO;
import com.inncore.beta.entity.SysMenu;
import com.inncore.beta.entity.SysPermission;
import com.inncore.beta.entity.SysUser;
import com.inncore.beta.mapper.SysUserMapper;
import com.inncore.beta.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 15:19:05
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysPermission> findPermissionListByUser(SysUser user) {
        return sysUserMapper.findPermissionListByUser(user);
    }

    @Override
    public List<SysMenu> findMenuListByUser(SysUser user) {
        return sysUserMapper.findMenuListByUser(user);
    }

    @Override
    public IPage<SysUserDTO> pageUserDTO(IPage<SysUser> page, Wrapper<SysUser> queryWrapper) {
        return sysUserMapper.pageUserDTO(page, queryWrapper);
    }

    @Override
    public SysUserDTO getUserDTOById(String uid) {
        return sysUserMapper.getUserDTOById(uid);
    }

    @Override
    public SysUserDTO getUserDTO(Wrapper<SysUser> wrapper) {
        return sysUserMapper.getUserDTO(wrapper);
    }
}
