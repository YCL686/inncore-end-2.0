package com.ymm.microservices.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymm.microservices.usercenter.entity.GeneratorConfig;
import com.ymm.microservices.usercenter.mapper.GeneratorConfigMapper;
import com.ymm.microservices.usercenter.service.GeneratorConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-23
 */
@Service
public class GeneratorConfigServiceImpl extends ServiceImpl<GeneratorConfigMapper, GeneratorConfig> implements GeneratorConfigService {

}
