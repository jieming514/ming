package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
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
    @RequiresPermissions("system:upmsDictType:read")
    String UpmsDictType() {
        return "system/upmsDictType/upmsDictType";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsDictType:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsDictTypeDO> upmsDictTypeList = upmsDictTypeService.list(query);
        int total = upmsDictTypeService.count(query);
        PageUtils pageUtils = new PageUtils(upmsDictTypeList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:upmsDictType:add")
    String add() {
        return "system/upmsDictType/add";
    }

    @GetMapping("/edit/{dictId}")
    @RequiresPermissions("system:upmsDictType:edit")
    String edit(@PathVariable("dictId") Long dictId, Model model) {
        UpmsDictTypeDO upmsDictType = upmsDictTypeService.get(dictId);
        model.addAttribute("upmsDictType", upmsDictType);
        return "system/upmsDictType/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:upmsDictType:add")
    public R save(UpmsDictTypeDO upmsDictType) {
        if (upmsDictTypeService.save(upmsDictType) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:upmsDictType:edit")
    public R update(UpmsDictTypeDO upmsDictType) {
        upmsDictTypeService.update(upmsDictType);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:upmsDictType:remove")
    public R remove(Long dictId) {
        if (upmsDictTypeService.remove(dictId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:upmsDictType:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] dictIds) {
        upmsDictTypeService.batchRemove(dictIds);
        return R.ok();
    }

}
