package com.ming.upms.system.controller;

import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsLogDO;
import com.ming.upms.system.service.UpmsLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 
@Controller
@RequestMapping("/system/upmsLog")
public class UpmsLogController {
	@Autowired
	private UpmsLogService upmsLogService;
	
	@GetMapping()
	@RequiresPermissions("system:upmsLog:upmsLog")
	String UpmsLog(){
	    return "system/upmsLog/upmsLog";
	}
	
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
	
	@GetMapping("/add")
	@RequiresPermissions("system:upmsLog:add")
	String add(){
	    return "system/upmsLog/add";
	}

	@GetMapping("/edit/{logId}")
	@RequiresPermissions("system:upmsLog:edit")
	String edit(@PathVariable("logId") Long logId,Model model){
		UpmsLogDO upmsLog = upmsLogService.get(logId);
		model.addAttribute("upmsLog", upmsLog);
	    return "system/upmsLog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsLog:add")
	public R save( UpmsLogDO upmsLog){
		if(upmsLogService.save(upmsLog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsLog:edit")
	public R update( UpmsLogDO upmsLog){
		upmsLogService.update(upmsLog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsLog:remove")
	public R remove( Long logId){
		if(upmsLogService.remove(logId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsLog:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] logIds){
		upmsLogService.batchRemove(logIds);
		return R.ok();
	}
	
}
