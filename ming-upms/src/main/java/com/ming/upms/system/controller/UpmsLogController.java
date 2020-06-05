package com.ming.upms.system.controller;

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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 13:31:45
 */
@Api(tags = "日志信息管理")
@Controller
@RequestMapping("/system/upmsLog")
public class UpmsLogController {
	@Autowired
	private UpmsLogService upmsLogService;

	@ApiOperation(value="用户操作查看页面", notes="用户操作查看页面")
	@GetMapping()
	@RequiresPermissions("system:upmsLog:upmsLog")
	String UpmsLog(){
	    return "system/upmsLog/upmsLog";
	}

	@ApiOperation(value="用户操作列表", notes="用户操作列表")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsLog:upmsLog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UpmsLogDO> upmsLogList = upmsLogService.list(query);
		int total = upmsLogService.count(query);
		PageUtils pageUtils = new PageUtils(upmsLogList, total);
		return pageUtils;
	}

	@ApiOperation(value="清理日志接口", notes="清理日志接口")
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsLog:remove")
	public R remove( Long logId){
		if(upmsLogService.remove(logId)>0){
		return R.ok();
		}
		return R.error();
	}

	@ApiOperation(value="批量清理用户日志接口", notes="批量清理用户日志接口")
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsLog:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] logIds){
		upmsLogService.batchRemove(logIds);
		return R.ok();
	}
	
}
