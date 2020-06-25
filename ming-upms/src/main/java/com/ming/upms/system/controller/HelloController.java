package com.ming.upms.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @PostMapping("/hello")
    @ResponseBody
    public String hello() {

        return "hello upms";
    }
}
