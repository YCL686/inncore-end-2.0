package com.inncore.beta.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inncore.beta.dto.SysMenuDTO;
import com.inncore.beta.entity.SysMenu;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 16:14:06
 */
public interface SysMenuService extends IService<SysMenu> {
    IPage<SysMenuDTO> pageMenuDTO(IPage<SysMenu> page, Wrapper<SysMenu> wrapper);

    List<SysMenuDTO> listMenuDTO(Wrapper wrapper);

    SysMenuDTO getMenuDTO(Wrapper<SysMenu> wrapper);
}
