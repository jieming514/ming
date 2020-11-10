package com.ming.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台管理系统
 */

@Controller
public class AdminController {

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "ming admin index";
    }

}
