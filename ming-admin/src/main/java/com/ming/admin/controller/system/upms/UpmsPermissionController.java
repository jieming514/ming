package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.domain.Tree;
import com.ming.common.enums.LogType;
import com.ming.common.utils.R;
import com.ming.common.annotation.Log;
import com.ming.upms.system.domain.UpmsPermissionDO;
import com.ming.upms.system.domain.UpmsSystemDO;
import com.ming.upms.system.service.UpmsPermissionService;
import com.ming.upms.system.service.UpmsSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源（一级菜单、二级菜单、按钮等）
 *
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 15:17:30
 */

@Api(tags = "资源管理页面")
@Controller("permissionController")
@RequestMapping("/system/upmsPermission")
public class UpmsPermissionController extends BaseController {


    @Autowired
    private UpmsPermissionService upmsPermissionService;

    @Autowired
    private UpmsSystemService upmsSystemService;


    @ApiOperation(value = "资源信息页面", notes = "资源信息页面")
    @GetMapping()
    @RequiresPermissions("system:upmsPermission:read")
    public String UpmsPermission() {
        return "system/upmsPermission/upmsPermission";
    }


    @ApiOperation(value = "资源信息列表", notes = "资源信息列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsPermission:read")
    public List<UpmsPermissionDO> list(@RequestParam Map<String, Object> params) {
        List<UpmsPermissionDO> upmsPermissionList = upmsPermissionService.getSystemPermissionList(params);
        return upmsPermissionList;
    }


    @ApiOperation(value = "新增资源页面", notes = "新增资源页面")
    @GetMapping("/add/{pid}")
    @RequiresPermissions("system:upmsPermission:add")
    @Log("添加资源页面")
    public String add(@PathVariable("pid") Long pid, Model model) {
        List<UpmsSystemDO> systemList = upmsSystemService.getAvalidList(new HashMap<>());
        UpmsPermissionDO pPermissionDO = upmsPermissionService.get(pid);
        if (pPermissionDO == null || pPermissionDO.getPermissionId() == null) {
            pPermissionDO = new UpmsPermissionDO();
            pPermissionDO.setPermissionId(0L);
            pPermissionDO.setName("根目录");
        }
        model.addAttribute("systemList", systemList);
        model.addAttribute("pPermissionDO", pPermissionDO);
        return "system/upmsPermission/add";
    }


    @ApiOperation(value = "编辑资源页面", notes = "编辑资源页面")
    @GetMapping("/edit/{permissionId}")
    @RequiresPermissions("system:upmsPermission:edit")
    @Log("编辑资源页面")
    public String edit(@PathVariable("permissionId") Long permissionId, Model model) {
        UpmsPermissionDO upmsPermission = upmsPermissionService.get(permissionId);
        List<UpmsSystemDO> systemList = upmsSystemService.getAvalidList(new HashMap<>());
        UpmsPermissionDO pPermissionDO = upmsPermissionService.get(upmsPermission.getPid());
        if (pPermissionDO == null || pPermissionDO.getPermissionId() == null) {
            pPermissionDO = new UpmsPermissionDO();
            pPermissionDO.setPermissionId(0L);
            pPermissionDO.setName("根目录");
        }
        model.addAttribute("upmsPermission", upmsPermission);
        model.addAttribute("pPermissionDO", pPermissionDO);
        model.addAttribute("systemList", systemList);
        return "system/upmsPermission/edit";
    }


    @ApiOperation(value = "获取图标信息", notes = "获取图标信息")
    @GetMapping("/icon")
    public String icon() {
        return "system/upmsPermission/icon";
    }


    @ApiOperation(value = "新增资源接口", notes = "新增资源接口")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:upmsPermission:add")
    @Log(value = "保存资源", type = LogType.INSERT)
    public R save(UpmsPermissionDO upmsPermission) {
        if (upmsPermissionService.save(upmsPermission) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "更新资源接口", notes = "更新资源接口")
    @ResponseBody
    @RequestMapping("/update")
    @Log(value = "修改资源", type = LogType.UPDATE)
    @RequiresPermissions("system:upmsPermission:edit")
    public R update(UpmsPermissionDO upmsPermission) {
        upmsPermissionService.update(upmsPermission);
        return R.ok();
    }


    @ApiOperation(value = "删除资源接口", notes = "删除资源接口")
    @PostMapping("/remove")
    @ResponseBody
    @Log(value = "删除资源", type = LogType.DELETE)
    @RequiresPermissions("system:upmsPermission:remove")
    public R remove(Long permissionId) {
        if (upmsPermissionService.remove(permissionId) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "批量删除资源信息接口", notes = "批量删除资源信息接口")
    @PostMapping("/batchRemove")
    @ResponseBody
    @Log(value = "批量删除资源", type = LogType.DELETE)
    @RequiresPermissions("system:upmsPermission:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] permissionIds) {
        upmsPermissionService.batchRemove(permissionIds);
        return R.ok();
    }


    @ApiOperation(value = "获取资源树页面", notes = "获取资源树页面")
    @GetMapping("/getPermissionTree/{roleId}")
    public String getPermissionTree(@PathVariable("roleId") Long roleId, Model model) {
        model.addAttribute("roleId", roleId);
        return "system/upmsPermission/tree";
    }


    @ApiOperation(value = "获取一个完整的角色资源树", notes = "获取一个完整的角色资源树")
    @ResponseBody
    @PostMapping("/getTree")
    public List<Tree<UpmsPermissionDO>> getTree(Long roleId) {
        List<Tree<UpmsPermissionDO>> treeList = new ArrayList<Tree<UpmsPermissionDO>>();
        treeList = upmsPermissionService.getTree(roleId);
        return treeList;
    }


    @ApiOperation(value = "获取角色拥有的资源", notes = "获取角色拥有的资源")
    @Log("获取资源树")
    @ResponseBody
    @PostMapping("/selectRoleHasPermission/{roleId}")
    public List<UpmsPermissionDO> selectRoleHasPermission(@PathVariable("roleId") Long roleId) {
        List<UpmsPermissionDO> upmsPermissionDOList = new ArrayList<>();
        upmsPermissionDOList = upmsPermissionService.selectRoleHasPermissionByRoleId(roleId);
        return upmsPermissionDOList;
    }

}
