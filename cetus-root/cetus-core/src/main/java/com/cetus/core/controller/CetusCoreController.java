package com.cetus.core.controller;

import com.cetus.core.mapper.core.SystemParamMapper;
import com.cetus.core.util.InnerSystemParamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/core")
public class CetusCoreController {
    @Resource
    private SystemParamMapper systemParamMapper;

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }

    @GetMapping("/prm/{paramGroupId}/{paramId}")
    public String getParamValue(@PathVariable("paramGroupId") String paramGroupId,
                                @PathVariable("paramId") String paramId) {
        return InnerSystemParamUtils.getParamValue(paramGroupId, paramId);
    }

    @GetMapping("/qry")
    public String query() {
        return systemParamMapper.selectList(null).toString();
    }
}
