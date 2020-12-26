package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.utils.MD5Utils;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.common.annotation.Log;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsUserRoleService;
import com.ming.upms.system.service.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户管理
 *
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-01 15:23:25
 */

@Api(tags = "用户管理页面")
@Controller("userController")
@RequestMapping("/system/upmsUser")
public class UpmsUserController extends BaseController {


    @Autowired
    private UpmsUserService upmsUserService;

    @Autowired
    private UpmsUserRoleService upmsUserRoleService;


    @ApiOperation(value = "用户信息页面", notes = "用户信息页面")
    @GetMapping()
    @RequiresPermissions("system:upmsUser:read")
    public String UpmsUser() {
        return "system/upmsUser/upmsUser";
    }


    @ApiOperation(value = "用户信息列表", notes = "用户信息列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsUser:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsUserDO> upmsUserList = upmsUserService.list(query);
        int total = upmsUserService.count(query);
        PageUtils pageUtils = new PageUtils(upmsUserList, total);
        return pageUtils;
    }


    @ApiOperation(value = "新增用户页面", notes = "新增用户页面")
    @GetMapping("/add")
    @Log("添加用户")
    @RequiresPermissions("system:upmsUser:add")
    public String add() {
        return "system/upmsUser/add";
    }


    @ApiOperation(value = "编辑用户页面", notes = "编辑用户页面")
    @GetMapping("/edit/{userId}")
    @Log("编辑用户")
    @RequiresPermissions("system:upmsUser:edit")
    public String edit(@PathVariable("userId") Long userId, Model model) {
        UpmsUserDO upmsUser = upmsUserService.selectUserByUserId(userId);
        model.addAttribute("upmsUser", upmsUser);
        return "system/upmsUser/edit";
    }


    @ApiOperation(value = "新增用户接口", notes = "新增用户接口")
    @ResponseBody
    @PostMapping("/save")
    @Log("保存用户")
    @RequiresPermissions("system:upmsUser:add")
    public R save(UpmsUserDO upmsUser) {
        String salt = RandomStringUtils.randomAlphanumeric(30);
        upmsUser.setSalt(salt);
        String password = upmsUser.getPassword() + salt;
        upmsUser.setPassword(MD5Utils.encrypt(upmsUser.getUsername(), password));
        if (upmsUserService.save(upmsUser) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "更新用户接口", notes = "更新用户接口")
    @ResponseBody
    @RequestMapping("/update")
    @Log("更新用户")
    @RequiresPermissions("system:upmsUser:edit")
    public R update(UpmsUserDO upmsUser) {
        upmsUserService.update(upmsUser);
        return R.ok();
    }


    @ApiOperation(value = "删除用户接口", notes = "删除用户接口")
    @PostMapping("/remove")
    @ResponseBody
    @Log("删除用户")
    @RequiresPermissions("system:upmsUser:remove")
    public R remove(Long userId) {
        if (upmsUserService.remove(userId) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "批量删除用户信息接口", notes = "批量删除用户信息接口")
    @PostMapping("/batchRemove")
    @ResponseBody
    @Log("批量删除用户")
    @RequiresPermissions("system:upmsUser:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] userIds) {
        upmsUserService.batchRemove(userIds);
        return R.ok();
    }


    @ApiOperation(value = "个人信息页面", notes = "个人信息页面")
    @GetMapping("/personal")
    @Log("编辑用户")
    @RequiresPermissions("system:upmsUser:edit")
    public String personal(Model model) {
        UpmsUserDO upmsUser = upmsUserService.selectUserByUserId(getUserId());
        model.addAttribute("user", upmsUser);
        return "system/upmsUser/personal";
    }


    @ApiOperation(value = "邮件唯一性校验", notes = "邮件唯一性校验")
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(UpmsUserDO upmsUserDO) {
        return upmsUserService.checkEmailUnique(upmsUserDO);
    }


    @ApiOperation(value = "手机号码唯一性校验", notes = "手机号码唯一性校验")
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(UpmsUserDO upmsUserDO) {
        return upmsUserService.checkPhoneUnique(upmsUserDO);
    }


    @ApiOperation(value = "密码有效性校验", notes = "密码有效性校验")
    @PostMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(Long userId, String password) {
        UpmsUserDO userDO = getUser();
        password += userDO.getSalt();
        password = MD5Utils.encrypt(userDO.getUsername(), password);
        if (userDO.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


    @ApiOperation(value = "重置密码接口", notes = "重置密码接口")
    @PostMapping("/resetPwd")
    @ResponseBody
    public R resetPwd(UpmsUserDO user) {
        if (!getUserId().equals(user.getUserId())) {
            return R.error("非用户本人操作！");
        }
        if (StringUtils.isBlank(user.getPassword())) {
            return R.error("新密码不能为空");
        }
        UpmsUserDO userDO = getUser();
        String password = user.getPassword() + userDO.getSalt();
        user.setPassword(MD5Utils.encrypt(userDO.getUsername(), password));
        if (upmsUserService.update(user) > 0) {
            return R.ok();
        }
        return R.error("为更新数据，更新失败！");
    }


}
