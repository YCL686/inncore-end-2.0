package com.inncore.beta.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inncore.beta.entity.SysDictItem;
import com.inncore.beta.mapper.SysDictItemMapper;
import com.inncore.beta.service.SysDictItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典详情表 服务实现类
 * </p>
 *
 * @author ymm
 * @since 2021-03-04
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements SysDictItemService {
    private static Logger log = LoggerFactory.getLogger(SysDictItemServiceImpl.class);
}
