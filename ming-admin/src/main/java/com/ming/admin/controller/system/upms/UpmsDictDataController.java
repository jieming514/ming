package com.ming.admin.controller.system.upms;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.annotation.Log;
import com.ming.common.enums.LogType;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsDictDataDO;
import com.ming.upms.system.service.UpmsDictDataService;
import io.swagger.annotations.ApiOperation;
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
    @RequiresPermissions("system:upmsDict:read")
    String UpmsDictData() {
        return "system/upmsDictData/upmsDictData";
    }

    @ApiOperation(value = "字典类型列表（分页）")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsDict:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsDictDataDO> upmsDictDataList = upmsDictDataService.list(query);
        int total = upmsDictDataService.count(query);
        PageUtils pageUtils = new PageUtils(upmsDictDataList, total);
        return pageUtils;
    }

    @ApiOperation(value = "字典类型列表（不分页）")
    @ResponseBody
    @GetMapping("/useList")
    @RequiresPermissions("system:upmsDict:read")
    public List<UpmsDictDataDO> useList(@RequestParam Map<String, Object> params) {
        List<UpmsDictDataDO> upmsDictDataList = upmsDictDataService.list(params);
        return upmsDictDataList;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:upmsDict:add")
    String add() {
        return "system/upmsDictData/add";
    }

    @GetMapping("/edit/{dictCode}")
    @RequiresPermissions("system:upmsDict:edit")
    String edit(@PathVariable("dictCode") Long dictCode, Model model) {
        UpmsDictDataDO upmsDictData = upmsDictDataService.get(dictCode);
        model.addAttribute("upmsDictData", upmsDictData);
        return "system/upmsDictData/edit";
    }

    @Log(value = "字典数据保存", type = LogType.INSERT)
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:upmsDict:add")
    public R save(UpmsDictDataDO upmsDictData) {
        upmsDictData.addCreator(getUserName());
        if (upmsDictDataService.save(upmsDictData) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Log(value = "字典数据更新", type = LogType.UPDATE)
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:upmsDict:edit")
    public R update(UpmsDictDataDO upmsDictData) {
        upmsDictData.addUpdater(getUserName());
        upmsDictDataService.update(upmsDictData);
        return R.ok();
    }

    @Log(value = "字典数据删除", type = LogType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:upmsDict:remove")
    public R remove(Long dictCode) {
        if (upmsDictDataService.remove(dictCode) > 0) {
            return R.ok();
        }
        return R.error();
    }

    @Log(value = "字典数据批量删除", type = LogType.DELETE)
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:upmsDict:remove")
    public R remove(@RequestParam("ids[]") Long[] dictCodes) {
        upmsDictDataService.batchRemove(dictCodes);
        return R.ok();
    }

}
