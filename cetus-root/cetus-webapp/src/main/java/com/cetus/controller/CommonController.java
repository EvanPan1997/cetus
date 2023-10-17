package com.cetus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/common")
@RestController
public class CommonController {
    @GetMapping("/demo")
    public String demo() {
        return "Hello";
    }
}
