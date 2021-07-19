package com.inncore.beta.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inncore.beta.dto.SysPermissionDTO;
import com.inncore.beta.entity.SysPermission;
import com.inncore.beta.mapper.SysPermissionMapper;
import com.inncore.beta.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 16:13:40
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public IPage<SysPermissionDTO> pagePermissionDTO(IPage<SysPermission> page, Wrapper<SysPermission> wrapper) {
        return sysPermissionMapper.pagePermissionDTO(page, wrapper);
    }

    @Override
    public SysPermissionDTO getPermissionDTO(Wrapper<SysPermission> wrapper) {
        return sysPermissionMapper.getPermissionDTO(wrapper);
    }
}
