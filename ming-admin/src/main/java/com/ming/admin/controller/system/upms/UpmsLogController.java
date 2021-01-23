package com.ming.admin.controller.system.upms;

import com.alibaba.excel.EasyExcel;
import com.ming.admin.controller.common.BaseController;
import com.ming.common.utils.DateUtils;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsLogDO;
import com.ming.upms.system.service.UpmsLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 用户操作日志
 *
 * @author ming
 * @date 2020-04-06 13:31:45
 */
@Api(tags = "日志信息管理")
@Controller("logController")
@RequestMapping("/system/upmsLog")
public class UpmsLogController extends BaseController {

    private static final String DOWNLOAD_FILE_NAME = "用户操作日志";
    private static final String DOWNLOAD_SHEET_NAME = "用户操作日志";

    @Autowired
    private UpmsLogService upmsLogService;


    @ApiOperation(value = "用户操作查看页面", notes = "用户操作查看页面")
    @GetMapping()
    @RequiresPermissions("system:upmsLog:read")
    public String upmsLog() {
        return "system/upmsLog/upmsLog";
    }


    @ApiOperation(value = "用户操作列表", notes = "用户操作列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsLog:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsLogDO> upmsLogList = upmsLogService.list(query);
        int total = upmsLogService.count(query);
        PageUtils pageUtils = new PageUtils(upmsLogList, total);
        return pageUtils;
    }


    @ApiOperation(value = "清理日志接口", notes = "清理日志接口")
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:upmsLog:remove")
    public R remove(Long logId) {
        if (upmsLogService.remove(logId) > 0) {
            return R.ok();
        }
        return R.error();
    }


    @ApiOperation(value = "批量清理用户日志接口", notes = "批量清理用户日志接口")
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:upmsLog:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] logIds) {
        upmsLogService.batchRemove(logIds);
        return R.ok();
    }

    @ApiOperation(value = "通过ID获取日志详细信息", notes = "通过ID获取日志详细信息")
    @GetMapping("/show/{logId}")
    @RequiresPermissions("system:upmsLog:read")
    public String show(@PathVariable("logId") Long logId, Model model) {
        UpmsLogDO upmsLogDO = upmsLogService.get(logId);
        model.addAttribute("upmsLog", upmsLogDO);
        return "system/upmsLog/show";
    }


    @ApiOperation(value = "导出日志", notes = "导出用户操作日志")
    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam Map<String, Object> params) throws IOException {
        //查询列表数据
        List<UpmsLogDO> upmsLogList = upmsLogService.list(params);

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(DOWNLOAD_FILE_NAME + "-" + DateUtils.getToday(), "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), UpmsLogDO.class)
                .sheet(DOWNLOAD_SHEET_NAME).doWrite(upmsLogList);
    }


}
