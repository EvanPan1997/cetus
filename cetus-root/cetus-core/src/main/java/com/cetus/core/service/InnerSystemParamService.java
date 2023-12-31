package com.cetus.core.service;

import com.cetus.core.mapper.core.SystemParamMapper;
import com.cetus.core.orm.entity.SystemParam;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
public class InnerSystemParamService {

    private static LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> systemParamMap = new LinkedHashMap<>();

    @Resource
    private SystemParamMapper systemParamMapper;

    public InnerSystemParamService() {
    }

    /**
     * config类初始化方法
     * */
    private void init() {
        initSystemParamMap();
    }

    public void initSystemParamMap() {
        List<SystemParam> systemParams = systemParamMapper.selectList(null);
        for (SystemParam param : systemParams) {
            String paramGroupId = param.getParamGroupId();
            String paramId = param.getParamId();
            String paramName = param.getParamName();
            String paramValue = param.getParamValue();
            addRecord(paramGroupId, paramId, paramName, paramValue);
        }

    }


    public void reloadSystemParamMap() {
        systemParamMap = new LinkedHashMap<>();
        initSystemParamMap();
    }

    public void addRecord(String paramGroupId, String paramId, String paramName, String paramValue) {
        addRecord(systemParamMap, paramGroupId, paramId, paramName, paramValue);
    }

    public void addRecord(LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> map,
                          String paramGroupId, String paramId, String paramName, String paramValue) {
        if (!map.containsKey(paramGroupId)) {
            map.put(paramGroupId, new LinkedHashMap<>());
        }
        LinkedHashMap<String, LinkedHashMap<String, String>> groupMap = map.get(paramGroupId);
        if (!groupMap.containsKey(paramId)) {
            groupMap.put(paramId, new LinkedHashMap<>());
        }
        LinkedHashMap<String, String> paramMap = groupMap.get(paramId);
        paramMap.put("paramName", paramName);
        paramMap.put("paramValue", paramValue);
    }

    public String getValue(String paramGroupId, String paramId) {
        if (!systemParamMap.containsKey(paramGroupId)) {
            return null;
        } else {
            LinkedHashMap<String, LinkedHashMap<String, String>> groupMap = systemParamMap.get(paramGroupId);
            if (!groupMap.containsKey(paramId)) {
                return null;
            } else {
                return groupMap.get(paramId).get("paramValue");
            }
        }
    }


}
