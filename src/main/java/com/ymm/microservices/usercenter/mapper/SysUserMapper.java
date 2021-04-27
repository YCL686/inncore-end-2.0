package com.ymm.microservices.usercenter.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ymm.microservices.usercenter.dto.SysUserDTO;
import com.ymm.microservices.usercenter.entity.SysMenu;
import com.ymm.microservices.usercenter.entity.SysPermission;
import com.ymm.microservices.usercenter.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-05 15:19:03
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysPermission> findPermissionListByUser(SysUser user);

    List<SysMenu> findMenuListByUser(SysUser user);

    IPage<SysUserDTO> pageUserDTO(IPage<SysUser> page, @Param(Constants.WRAPPER) Wrapper<SysUser> queryWrapper);

    SysUserDTO getUserDTOById(String uid);

    SysUserDTO getUserDTO(@Param(Constants.WRAPPER) Wrapper<SysUser> wrapper);
}
