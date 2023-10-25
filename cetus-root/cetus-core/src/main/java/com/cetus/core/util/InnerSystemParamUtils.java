package com.cetus.core.util;

import com.cetus.core.service.InnerSystemParamService;

public class InnerSystemParamUtils {

    public static String getParamValue(String paramGroupId, String paramId) {
        InnerSystemParamService instance = (InnerSystemParamService) ApplicationContextUtil.getBean("innerSystemParamService");
        return instance == null ? "" : instance.getValue(paramGroupId, paramId);
    }
}
