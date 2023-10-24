package com.cetus.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core")
public class CetusCoreController {
    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }
}
