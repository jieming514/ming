package com.ming.system.controller;

import com.ming.common.controller.BaseController;
import com.ming.common.util.R;
import com.ming.system.domain.RoleDO;
import com.ming.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: 用户角色管理
 *
 * @auther: jie_ming514@163.com
 * @date: 2018/10/13 14:51
 */

@Controller
@RequestMapping("/sys/role")
public class RoleController extends BaseController {

    private final String PREFIX = "system/role";

    @Autowired
    private RoleService roleService;


    @RequiresPermissions("sys:role:role")
    @GetMapping(value = "")
    public String role() {
        return PREFIX + "/role";
    }


    @RequiresPermissions("sys:role:role")
    @GetMapping(value = "/list")
    @ResponseBody
    public List list(@RequestParam Map<String, Object> params) {
        return roleService.list(params);
    }


    /**
     * 功能描述: 添加角色页面
     *
     * @param:
     * @return: /sys/role/add
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:50
     */
    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    public String add() {
        return PREFIX + "/add";
    }

    /**
     * 功能描述: 新增角色
     *
     * @param: 角色信息
     * @return: 新增成功或失败
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:51
     */
    @RequiresPermissions("sys:role:add")
    @PostMapping("/save")
    @ResponseBody
    public R save(RoleDO roleDO) {
        if (roleService.save(roleDO) > 0) {
            return R.ok();
        } else {
            return R.error(1, "新增角色失败！");
        }
    }


    /**
     * 功能描述: 编辑角色页面
     *
     * @param:
     * @return: /sys/role/edit
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:51
     */
    @RequiresPermissions("sys:role:edit")
    @GetMapping("/edit/{pId}")
    public String edit(Model model, @PathVariable("pId") Long id) {
        RoleDO roleDO = roleService.get(id);
        model.addAttribute("role", roleDO);
        return PREFIX + "/edit";
    }

    /**
     * 功能描述: 编辑角色
     *
     * @param: 角色信息
     * @return: 编辑成果或失败
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:52
     */
    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody
    public R update(RoleDO roleDO) {
        if (roleService.update(roleDO) > 0) {
            return R.ok();
        } else {
            return R.error(1, "角色更新失败");
        }
    }

    @RequiresPermissions("sys:role:remove")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (roleService.remove(id)) {
            return R.ok();
        } else {
            return R.error(1, "角色删除失败");
        }
    }


}
