package com.ming.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/19 23:10
 */
@RequestMapping("/mybatis/common/log")
@Controller
public class LogController extends BaseController {

    private static final String PREFIX = "/mybatis/common/log";

    @GetMapping()
    private String log() {
        return PREFIX + "/log";
    }




}
