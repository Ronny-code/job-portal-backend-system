package com.job.portal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")


public class HelloController{

    @GetMapping("/hello")
    public String hello() {
        return "job portal backend is running ";

    }
}