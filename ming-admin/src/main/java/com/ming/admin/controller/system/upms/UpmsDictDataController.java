package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsDictDataDO;
import com.ming.upms.system.service.UpmsDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 字典数据表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2021-01-25 23:16:01
 */

@Controller
@RequestMapping("/system/upmsDictData")
public class UpmsDictDataController extends BaseController {
    @Autowired
    private UpmsDictDataService upmsDictDataService;

    @GetMapping()
    @RequiresPermissions("system:upmsDictData:read")
    String UpmsDictData() {
        return "system/upmsDictData/upmsDictData";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsDictData:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsDictDataDO> upmsDictDataList = upmsDictDataService.list(query);
        int total = upmsDictDataService.count(query);
        PageUtils pageUtils = new PageUtils(upmsDictDataList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:upmsDictData:add")
    String add() {
        return "system/upmsDictData/add";
    }

    @GetMapping("/edit/{dictCode}")
    @RequiresPermissions("system:upmsDictData:edit")
    String edit(@PathVariable("dictCode") Long dictCode, Model model) {
        UpmsDictDataDO upmsDictData = upmsDictDataService.get(dictCode);
        model.addAttribute("upmsDictData", upmsDictData);
        return "system/upmsDictData/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:upmsDictData:add")
    public R save(UpmsDictDataDO upmsDictData) {
        if (upmsDictDataService.save(upmsDictData) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:upmsDictData:edit")
    public R update(UpmsDictDataDO upmsDictData) {
        upmsDictDataService.update(upmsDictData);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:upmsDictData:remove")
    public R remove(Long dictCode) {
        if (upmsDictDataService.remove(dictCode) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:upmsDictData:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] dictCodes) {
        upmsDictDataService.batchRemove(dictCodes);
        return R.ok();
    }

}
