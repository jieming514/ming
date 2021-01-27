package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.annotation.Log;
import com.ming.common.enums.LogType;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsDictTypeDO;
import com.ming.upms.system.service.UpmsDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 字典类型表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2021-01-25 23:06:39
 */

@Controller
@RequestMapping("/system/upmsDictType")
public class UpmsDictTypeController extends BaseController {
    @Autowired
    private UpmsDictTypeService upmsDictTypeService;

    @GetMapping()
    @RequiresPermissions("system:upmsDict:read")
    String UpmsDictType() {
        return "system/upmsDictType/upmsDictType";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsDict:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsDictTypeDO> upmsDictTypeList = upmsDictTypeService.list(query);
        int total = upmsDictTypeService.count(query);
        PageUtils pageUtils = new PageUtils(upmsDictTypeList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:upmsDict:add")
    String add() {
        return "system/upmsDictType/add";
    }

    @GetMapping("/edit/{dictId}")
    @RequiresPermissions("system:upmsDict:edit")
    String edit(@PathVariable("dictId") Long dictId, Model model) {
        UpmsDictTypeDO upmsDictType = upmsDictTypeService.get(dictId);
        model.addAttribute("upmsDictType", upmsDictType);
        return "system/upmsDictType/edit";
    }


    @Log(value = "保存字典类型", type = LogType.INSERT)
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:upmsDict:add")
    public R save(UpmsDictTypeDO upmsDictType) {
        upmsDictType.addCreator(getUserName());
        if (upmsDictTypeService.save(upmsDictType) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Log(value = "修改字典类型", type = LogType.UPDATE)
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:upmsDict:edit")
    public R update(UpmsDictTypeDO upmsDictType) {
        upmsDictType.addUpdater(getUserName());
        upmsDictTypeService.update(upmsDictType);
        return R.ok();
    }


    @Log(value = "删除字典类型", type = LogType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:upmsDict:remove")
    public R remove(Long dictId) {
        if (upmsDictTypeService.remove(dictId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Log(value = "批量删除字典类型", type = LogType.DELETE)
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:upmsDict:remove")
    public R remove(@RequestParam("ids[]") Long[] dictIds) {
        upmsDictTypeService.batchRemove(dictIds);
        return R.ok();
    }

}
