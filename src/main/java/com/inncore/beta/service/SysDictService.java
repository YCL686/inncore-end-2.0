package com.inncore.beta.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inncore.beta.dto.SysDictDto;
import com.inncore.beta.entity.SysDict;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 字典 服务接口
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */

public interface SysDictService extends IService<SysDict> {
    IPage<SysDictDto> pageSysDictDto(IPage<SysDict> page, @Param(Constants.WRAPPER) Wrapper<SysDict> wrapper);
    int countSysDictDto(@Param(Constants.WRAPPER) Wrapper<SysDict> wrapper);
    SysDictDto getDto(Wrapper<SysDict> wrapper);
}
