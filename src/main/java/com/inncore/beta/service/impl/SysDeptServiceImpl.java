package com.inncore.beta.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inncore.beta.dto.SysDeptDTO;
import com.inncore.beta.entity.SysDept;
import com.inncore.beta.mapper.SysDeptMapper;
import com.inncore.beta.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门管理(SysDept)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 16:14:58
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public IPage<SysDeptDTO> pageDeptDTO(IPage<SysDept> page, Wrapper<SysDept> wrapper) {
        return this.sysDeptMapper.pageDeptDTO(page, wrapper);
    }

    @Override
    public List<SysDeptDTO> listDeptDTO(LambdaQueryWrapper<SysDept> wrapper) {
        return sysDeptMapper.listDeptDTO(wrapper);
    }
}
