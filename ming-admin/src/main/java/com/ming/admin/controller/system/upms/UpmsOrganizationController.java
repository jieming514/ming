package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.domain.Tree;
import com.ming.common.utils.R;
import com.ming.common.annotation.Log;
import com.ming.upms.system.domain.UpmsOrganizationDO;
import com.ming.upms.system.service.UpmsOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 组织管理
 *
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 14:29:52
 */

@Api(tags = "组织管理页面")
@Controller("organizationController")
@RequestMapping("/system/upmsOrganization")
public class UpmsOrganizationController extends BaseController {


    @Autowired
    private UpmsOrganizationService upmsOrganizationService;


    @ApiOperation(value = "组织管理页面", notes = "组织管理页面")
    @GetMapping()
    @RequiresPermissions("system:upmsOrganization:read")
    public String UpmsOrganization() {
        return "system/upmsOrganization/upmsOrganization";
    }

    
    @ApiOperation(value = "组织列表接口", notes = "组织列表接口")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsOrganization:read")
    public List<UpmsOrganizationDO> list(@RequestParam Map<String, Object> params) {
        List<UpmsOrganizationDO> upmsOrganizationList = upmsOrganizationService.list(params);
        return upmsOrganizationList;
    }


    @ApiOperation(value = "新增组织页面", notes = "新增组织页面")
    @GetMapping("/add")
    @RequiresPermissions("system:upmsOrganization:add")
    @Log("添加组织")
    public String add() {
        return "system/upmsOrganization/add";
    }


    @ApiOperation(value = "编辑组织页面", notes = "编辑组织页面")
    @GetMapping("/edit/{organizationId}")
    @RequiresPermissions("system:upmsOrganization:edit")
    @Log("编辑组织")
    public String edit(@PathVariable("organizationId") Long organizationId, Model model) {
        UpmsOrganizationDO upmsOrganization = upmsOrganizationService.getOrganizationById(organizationId);
        model.addAttribute("upmsOrganization", upmsOrganization);
        return "system/upmsOrganization/edit";
    }


    @ApiOperation(value = "新增组织信息接口", notes = "新增组织信息接口")
    @ResponseBody
    @PostMapping("/save")
    @Log("保存组织")
    @RequiresPermissions("system:upmsOrganization:add")
    public R save(UpmsOrganizationDO upmsOrganization) {
        if (upmsOrganizationService.save(upmsOrganization) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "删除组织信息接口", notes = "删除组织信息接口")
    @Log("删除组织")
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:upmsOrganization:remove")
    public R remove(Long organizationId) {
        if (upmsOrganizationService.remove(organizationId) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "批量删除组织信息接口", notes = "批量删除组织信息接口")
    @Log("批量删除组织")
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:upmsOrganization:remove")
    public R remove(@RequestParam("ids[]") Long[] organizationIds) {
        upmsOrganizationService.batchRemove(organizationIds);
        return R.ok();
    }


    @ApiOperation(value = "获取组织树页面", notes = "获取组织树页面")
    @GetMapping("/getOrganizationTree")
    public String getOrganizationTree() {
        return "system/upmsOrganization/tree";
    }


    @ApiOperation(value = "获取组织树接口", notes = "获取组织树接口")
    @Log("获取组织树")
    @PostMapping("/getTree")
    @ResponseBody
    public Tree<UpmsOrganizationDO> getTree() {
        Tree<UpmsOrganizationDO> tree = new Tree<UpmsOrganizationDO>();
        tree = upmsOrganizationService.getTree();
        return tree;
    }


    @ApiOperation(value = "修改组织信息接口", notes = "修改组织信息接口")
    @Log("更新组织")
    @RequiresPermissions("system:upmsOrganization:edit")
    @RequestMapping("/update")
    @ResponseBody
    public R update(UpmsOrganizationDO upmsOrganization) {
        upmsOrganizationService.update(upmsOrganization);
        return R.ok();
    }

}
