package com.ymm.microservices.usercenter.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ymm.microservices.usercenter.dto.SysDictDto;
import com.ymm.microservices.usercenter.entity.SysDict;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 字典 数据库访问接口
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */
@Repository
public interface SysDictMapper extends BaseMapper<SysDict> {
    IPage<SysDictDto> pageSysDictDto(IPage<SysDict> page, @Param(Constants.WRAPPER) Wrapper<SysDict> wrapper);
    int countSysDictDto(@Param(Constants.WRAPPER) Wrapper<SysDict> wrapper);

    SysDictDto getDto(@Param(Constants.WRAPPER) Wrapper<SysDict> wrapper);
}
