package com.ming.common.controller;

import com.ming.common.domain.LogDO;
import com.ming.common.domain.PageDO;
import com.ming.common.service.LogService;
import com.ming.common.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/19 23:10
 */
@RequestMapping("/common/log")
@Controller
public class LogController extends BaseController {

    private static final String PREFIX = "/common/log";

    @Autowired
    private LogService logService;

    @GetMapping()
    public String log() {
        return PREFIX + "/log";
    }

    @GetMapping("/list")
    @ResponseBody
    public PageDO<LogDO> list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        return logService.queryList(query);
    }


}
