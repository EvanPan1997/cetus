package com.cetus.platform.entity;

import com.cetus.mapper.BaseSystemParamMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class SystemParam implements InitializingBean {

    @Resource
    private BaseSystemParamMapper baseSystemParamMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("系统参数初始化开始");

        List<BaseSystemParam> params = baseSystemParamMapper.selectList(null);
        log.info(params.toString());

        log.info("系统参数初始化完成");
    }


}
