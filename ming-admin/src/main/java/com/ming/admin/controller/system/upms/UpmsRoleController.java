package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.common.annotation.Log;
import com.ming.upms.system.domain.UpmsRoleDO;
import com.ming.upms.system.domain.UpmsRolePermissionDO;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsRolePermissionService;
import com.ming.upms.system.service.UpmsRoleService;
import com.ming.upms.system.service.UpmsUserRoleService;
import com.ming.upms.system.service.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-11 20:08:05
 */

@Api(tags = "角色管理页面")
@Controller("roleController")
@RequestMapping("/system/upmsRole")
public class UpmsRoleController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UpmsRoleController.class);

    @Autowired
    private UpmsRoleService upmsRoleService;

    @Autowired
    private UpmsRolePermissionService upmsRolePermissionService;

    @Autowired
    private UpmsUserRoleService upmsUserRoleService;

    @Autowired
    private UpmsUserService upmsUserService;

    @ApiOperation(value = "角色信息页面", notes = "角色信息页面")
    @GetMapping()
    @RequiresPermissions("system:upmsRole:read")
    String UpmsRole() {
        return "system/upmsRole/upmsRole";
    }

    @ApiOperation(value = "角色信息列表", notes = "角色信息列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsRole:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsRoleDO> upmsRoleList = upmsRoleService.list(query);
        int total = upmsRoleService.count(query);
        PageUtils pageUtils = new PageUtils(upmsRoleList, total);
        return pageUtils;
    }

    @ApiOperation(value = "新增角色页面", notes = "新增角色页面")
    @GetMapping("/add")
    @RequiresPermissions("system:upmsRole:add")
    @Log("添加角色")
    public String add() {
        return "system/upmsRole/add";
    }


    @ApiOperation(value = "编辑角色页面", notes = "编辑角色页面")
    @Log("编辑角色页面")
    @GetMapping("/edit/{roleId}")
    @RequiresPermissions("system:upmsRole:edit")
    public String edit(@PathVariable("roleId") Long roleId, Model model) {
        UpmsRoleDO upmsRole = upmsRoleService.get(roleId);
        model.addAttribute("upmsRole", upmsRole);
        return "system/upmsRole/edit";
    }


    @ApiOperation(value = "新增角色接口", notes = "新增角色接口")
    @ResponseBody
    @PostMapping("/save")
    @Log("保存角色信息")
    @RequiresPermissions("system:upmsRole:add")
    public R save(UpmsRoleDO upmsRole) {
        if (upmsRoleService.save(upmsRole) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "更新角色接口", notes = "更新角色接口")
    @ResponseBody
    @RequestMapping("/update")
    @Log("修改角色信息")
    @RequiresPermissions("system:upmsRole:edit")
    public R update(UpmsRoleDO upmsRole, Long[] permissionArr) {
        List<UpmsRolePermissionDO> upmsRolePermissionDOList = new ArrayList<UpmsRolePermissionDO>();
        upmsRoleService.update(upmsRole);
        upmsRolePermissionService.deleteRolePermissionByRoleId(upmsRole.getRoleId());
        for (Long permission : permissionArr) {
            UpmsRolePermissionDO upmsRolePermissionDO = new UpmsRolePermissionDO();
            upmsRolePermissionDO.setRoleId(upmsRole.getRoleId());
            upmsRolePermissionDO.setPermissionId(permission);
            upmsRolePermissionDOList.add(upmsRolePermissionDO);
        }
        upmsRolePermissionService.batchInsert(upmsRolePermissionDOList);
        return R.ok();
    }


    @ApiOperation(value = "删除角色接口", notes = "删除角色接口")
    @PostMapping("/remove")
    @ResponseBody
    @Log("删除角色")
    @RequiresPermissions("system:upmsRole:remove")
    public R remove(Long roleId) {
        if (upmsRoleService.remove(roleId) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "批量删除角色信息接口", notes = "批量删除角色信息接口")
    @PostMapping("/batchRemove")
    @ResponseBody
    @Log("批量删除角色")
    @RequiresPermissions("system:upmsRole:remove")
    public R remove(@RequestParam("ids[]") Long[] roleIds) {
        upmsRoleService.batchRemove(roleIds);
        return R.ok();
    }


    @ApiOperation(value = "角色授权用户页面", notes = "角色授权用户页面")
    @GetMapping("/authRole/{roleId}")
    @RequiresPermissions("system:upmsRole:read")
    public String authRole(@PathVariable("roleId") Long roleId, Model model) {
        UpmsRoleDO upmsRoleDO = upmsRoleService.get(roleId);
        model.addAttribute("upmsRoleDO", upmsRoleDO);
        return "system/upmsRole/authUser";
    }


    @ApiOperation(value = "查询授权的用户列表", notes = "查询授权的用户列表")
    @GetMapping("/selectAuthRoleUser")
    @RequiresPermissions("system:upmsRole:read")
    @ResponseBody
    public PageUtils selectAuthRoleUserByRoleId(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<UpmsUserDO> upmsUserDOList = new ArrayList<>();
        int count = upmsUserService.selectUserCountByRole(query);
        if (count > 0) {
            upmsUserDOList = upmsUserService.selectUserByRole(query);
        }
        PageUtils pageUtils = new PageUtils(upmsUserDOList, count);
        return pageUtils;
    }


    @ApiOperation(value = "删除角色的用户", notes = "删除角色的用户")
    @PostMapping("/deleteUserRoleInfo")
    @Log("删除角色的用户")
    @ResponseBody
    public R deleteUserRoleInfo(Long roleId, Long userId) {
        if (upmsUserRoleService.deleteUserRoleInfo(roleId, userId) > 0) {
            return R.ok();
        }
        return R.error("删除角色的用户失败");
    }


    @ApiOperation(value = "批量删除角色的用户", notes = "批量删除角色的用户")
    @PostMapping("/batchRemoveRole")
    @Log("批量删除角色的用户")
    @ResponseBody
    public R batchRemoveRole(@RequestParam("roleId") Long roleId,
                             @RequestParam("ids[]") Long[] userIds) {
        try {
            int count = upmsUserRoleService.batchRemoveRole(roleId, userIds);
            if (count > 0) {
                return R.ok("新增" + count + "条记录！");
            }
            return R.error("用户均已存在，无需新增！");
        } catch (RuntimeException e) {
            return R.error();
        }
    }


    @ApiOperation(value = "选择角色的用户页面", notes = "选择角色的用户页面")
    @GetMapping("/selectUser/{roleId}")
    public String selectUser(@PathVariable("roleId") Long roleId, Model model) {
        model.addAttribute("roleId", roleId);
        return "system/upmsRole/selectUser";
    }


    @ApiOperation(value = "添加角色拥有用户", notes = "添加角色拥有用户")
    @PostMapping("/addRoleForUser")
    @Log("添加角色拥有用户")
    @ResponseBody
    public R addRoleForUser(@RequestParam("roleId") Long roleId,
                            @RequestParam("ids[]") Long[] userIds) {
        try {
            int count = upmsUserRoleService.batchAddRole(roleId, userIds);
            if (count > 0) {
                return R.ok("新增" + count + "条记录！");
            }
            return R.error("用户均已存在，无需新增！");
        } catch (RuntimeException e) {
            return R.error();
        }
    }


    @ApiOperation(value = "通过用户名查找角色", notes = "通过用户名查找角色")
    @ResponseBody
    @GetMapping("/selectRoleByUserId/{userId}")
    public PageUtils list(@PathVariable("userId") Long userId) {

        int total = upmsRoleService.selectRoleCountByUserId(userId);
        List<UpmsRoleDO> upmsRoleList = upmsRoleService.selectRoleByUserId(userId);
        PageUtils pageUtils = new PageUtils(upmsRoleList, total);
        return pageUtils;
    }

}
