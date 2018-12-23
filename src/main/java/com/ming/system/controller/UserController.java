package com.ming.system.controller;


import com.ming.common.controller.BaseController;
import com.ming.common.util.*;
import com.ming.system.domain.UserDO;
import com.ming.system.domain.UserVO;
import com.ming.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 用户管理
 */
@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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
        userDO.setCreateDate(new Date());
        userDO.setUserIdCreate(getUserId());
        if(userService.save(userDO) > 0) {
            return R.ok();
        } else {
            return R.error(1, "写入用户信息失败！");
        }

    }

    /**
     * 功能描述: 编辑页面
     *
     * @param: 用户ID
     * @return: 编辑页面
     * @auther: jie_ming514@163.com
     * @date: 2018/12/16 23:03
     */
    @GetMapping("/edit/{pId}")
    public String edit(ModelMap modelMap, @PathVariable("pId") Long pId) {
        UserDO userDO = userService.get(pId);
        logger.debug(userDO.toString());
        modelMap.addAttribute("user",userDO);
        return PREFIX + "/edit";
    }

    @RequiresPermissions("sys:user:edit")
    @PostMapping("/update")
    @ResponseBody
    public R update(UserDO userDO) {
        if(userService.update(userDO) > 0) {
            return R.ok();
        }else {
            return R.error(500,"更新失败，未更新到数据！");
        }
    }


    /**
     * 功能描述: 修改密码页面
     *
     * @param: 用户ID
     * @return: 修改密码页面
     * @auther: jie_ming514@163.com
     * @date: 2018/12/17 22:29
     */
    @GetMapping("/resetPwd/{pId}")
    public String resetPwd(ModelMap modelMap, @PathVariable("pId") Long pId) {
        UserDO userDO = userService.get(pId);
        logger.debug(userDO.toString());
        modelMap.addAttribute("user",userDO);
        return PREFIX + "/reset_pwd";
    }


    @RequiresPermissions("sys:user:edit")
    @PostMapping("/adminResetPwd")
    @ResponseBody
    public R adminResetPwd(UserVO userVO) {
        int count = 0;
        try {
            count = userService.adminResetPwd(userVO);
            if(count > 0) {
                return R.ok("密码重置成功！");
            }else {
                return R.error(500,"未找到用户信息，密码重置失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(501,e.getMessage());
        }
    }


    @RequiresPermissions("sys:user:remove")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        try {
            int count = userService.remove(id);
            if ( count > 0) {
                return R.ok("删除用户成功！");
            } else {
                return R.error(500, "未找到用户信息，删除用户失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(500, ErrorUtils.makeErrorCode() + e.getMessage());
        }
    }


}
