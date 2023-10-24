package com.cetus.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Nullable
    public static <T> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            return null;
        }
    }

    @Nullable
    public static Object getBean(String name) {
        try {
            return context.getBean(name);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
            return null;
        }
    }
}
