package com.inncore.beta.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inncore.beta.dto.SysDictDto;
import com.inncore.beta.entity.SysDict;
import com.inncore.beta.mapper.SysDictMapper;
import com.inncore.beta.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典 服务实现类
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    private static Logger log = LoggerFactory.getLogger(SysDictServiceImpl.class);

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public IPage<SysDictDto> pageSysDictDto(IPage<SysDict> page, Wrapper<SysDict> wrapper) {
        return sysDictMapper.pageSysDictDto(page, wrapper);
    }

    @Override
    public int countSysDictDto(Wrapper<SysDict> wrapper) {
        return sysDictMapper.countSysDictDto(wrapper);
    }

    @Override
    public SysDictDto getDto(Wrapper<SysDict> wrapper) {
        return sysDictMapper.getDto(wrapper);
    }
}
