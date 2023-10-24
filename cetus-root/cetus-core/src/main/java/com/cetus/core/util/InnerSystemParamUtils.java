package com.cetus.core.util;

import com.cetus.core.service.InnerSystemParamService;

public class InnerSystemParamUtils {

    public static String getParamValue(String paramGroupId, String paramId) {
        InnerSystemParamService instance = InnerSystemParamService.getInstance();
        String value = instance.getValue(paramGroupId, paramId);
        return value == null ? "" : value;
    }
}
