package com.ming.system.controller;


import com.ming.common.controller.BaseController;
import com.ming.common.util.MD5Utils;
import com.ming.common.util.PageUtils;
import com.ming.common.util.Query;
import com.ming.common.util.R;
import com.ming.system.domain.UserDO;
import com.ming.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 用户管理
 */
@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    private final String PREFIX = "system/user";
    @Autowired
    private UserService userService;


    @RequestMapping("/getUserName")
    public String getUser(ModelMap map, Long userId) {
        UserDO user = userService.get(userId);
        map.addAttribute("user",user);
        return "index";
    }

    @GetMapping(value = "")
    public String user() {
        return PREFIX + "/user";
    }


    @GetMapping(value = "/list")
    @ResponseBody
    public PageUtils list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        int total = userService.count(query);
        List<UserDO> userDOList = userService.list(query);
        PageUtils pageUtil = new PageUtils(total, userDOList);
        return pageUtil;
    }


    @RequiresPermissions("sys:user:user")
    @GetMapping("/add")
    public String add() {
        return PREFIX + "/add";
    }


    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !userService.exit(params);
    }

    @RequiresPermissions("sys:user:user")
    @PostMapping("/save")
    @ResponseBody
    public R save(UserDO userDO) {
        userDO.setPassword(MD5Utils.encrypt(userDO.getUserName(), userDO.getPassword()));
        if(userService.save(userDO) > 0) {
            return R.ok();
        } else {
            return R.error(1, "写入用户信息失败！");
        }

    }



}
