package com.ming.system.controller;

import com.ming.common.annotation.Log;
import com.ming.common.domain.Tree;
import com.ming.common.util.R;
import com.ming.system.domain.DeptDO;
import com.ming.system.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: 部门信息
 *
 * @auther: jie_ming514@163.com
 * @date: 2018/10/29 22:12
 */
@Controller
@RequestMapping("/system/sysDept")
public class DeptController {

    private final static String PREFIX = "system/dept";

    @Autowired
    private DeptService deptService;

    @Log("部门管理界面")
    @RequiresPermissions("system:sysDept:sysDept")
    @GetMapping(value = "")
    public String dept() {
        return PREFIX + "/dept";
    }

    @Log("部门列表")
    @RequiresPermissions("system:sysDept:sysDept")
    @GetMapping(value = "/list")
    @ResponseBody
    public List<DeptDO> list(@RequestParam Map<String, Object> params) {
        return deptService.list(params);
    }

    @Log("新增部门页面")
    @RequiresPermissions("system:sysDept:add")
    @GetMapping(value = "/add/{pId}")
    public String add(@PathVariable("pId") Long deptId, Model model) {
        model.addAttribute("pId", deptId);
        if (deptId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", deptService.get(deptId).getName());
        }
        return PREFIX + "/add";
    }

    @Log("新增部门")
    @RequiresPermissions("system:sysDept:add")
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(DeptDO deptDO) {
        if (deptService.save(deptDO) > 0) {
            return R.ok();
        } else {
            return R.error(1, "插入部分信息失败！");
        }
    }

    @Log("删除部门")
    @RequiresPermissions("system:sysDept:remove")
    @PostMapping(value = "/remove")
    @ResponseBody
    public R remove(Long deptId) {
        if (deptService.remove(deptId)) {
            return R.ok();
        } else {
            return R.error(1, "插入部分信息失败！");
        }
    }

    @Log("编辑部门页面")
    @RequiresPermissions("system:sysDept:edit")
    @GetMapping(value = "/edit/{pId}")
    public String edit(@PathVariable("pId") Long deptId, Model model) {
        DeptDO sysDept = deptService.get(deptId);
        model.addAttribute("sysDept", sysDept);
        if(sysDept.getParentId() == 0) {
            model.addAttribute("parentDeptName", "根目录");
        } else {
            DeptDO parDept = deptService.get(sysDept.getParentId());
            model.addAttribute("parentDeptName", parDept.getName());
        }
        return PREFIX + "/edit";
    }

    @Log("修改部门信息")
    @RequiresPermissions("system:sysDept:edit")
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(DeptDO deptDO) {
        if(deptService.update(deptDO) > 0) {
            return R.ok();
        } else {
            return R.error(1,"修改部门信息失败！");
        }
    }

    @Log("展示部门结构树")
    @RequiresPermissions("system:sysDept:sysDept")
    @GetMapping(value = "/tree")
    @ResponseBody
    public Tree<DeptDO> tree() {
        return deptService.getTree();
    }


    @GetMapping("/treeView")
    String treeView() {
        return  PREFIX + "/deptTree";
    }

}
