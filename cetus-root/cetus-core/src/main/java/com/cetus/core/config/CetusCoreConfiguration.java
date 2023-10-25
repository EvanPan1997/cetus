package com.cetus.core.config;

import com.cetus.core.service.InnerSystemParamService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class CetusCoreConfiguration {
    @Bean(name = "innerSystemParamService", initMethod = "init")
    public InnerSystemParamService getInnerSystemParamService() {
        return new InnerSystemParamService();
    }
}
