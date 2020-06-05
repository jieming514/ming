package com.ming.upms.system.controller;

import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.common.annotation.Log;
import com.ming.upms.system.domain.UpmsSystemDO;
import com.ming.upms.system.service.UpmsSystemService;
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
 * 系统
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-04 13:04:29
 */

@Api(tags = "系统管理页面")
@Controller
@RequestMapping("/system/upmsSystem")
public class UpmsSystemController {
	@Autowired
	private UpmsSystemService upmsSystemService;

	@ApiOperation(value="系统信息页面", notes="系统信息页面")
	@GetMapping()
	@RequiresPermissions("system:upmsSystem:upmsSystem")
	String UpmsSystem(){
	    return "system/upmsSystem/upmsSystem";
	}

	@ApiOperation(value="系统信息列表", notes="系统信息列表")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsSystem:upmsSystem")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UpmsSystemDO> upmsSystemList = upmsSystemService.list(query);
		int total = upmsSystemService.count(query);
		PageUtils pageUtils = new PageUtils(upmsSystemList, total);
		return pageUtils;
	}

	@ApiOperation(value="新增系统页面", notes="新增系统页面")
	@GetMapping("/add")
	@Log("添加系统")
	@RequiresPermissions("system:upmsSystem:add")
	String add(){
	    return "system/upmsSystem/add";
	}

	@ApiOperation(value="编辑系统页面", notes="编辑系统页面")
	@GetMapping("/edit/{systemId}")
	@Log("编辑系统")
	@RequiresPermissions("system:upmsSystem:edit")
	String edit(@PathVariable("systemId") Long systemId,Model model){
		UpmsSystemDO upmsSystem = upmsSystemService.get(systemId);
		model.addAttribute("upmsSystem", upmsSystem);
	    return "system/upmsSystem/edit";
	}

	@ApiOperation(value="新增系统接口", notes="新增系统接口")
	@ResponseBody
	@PostMapping("/save")
	@Log("保存系统")
	@RequiresPermissions("system:upmsSystem:add")
	public R save( UpmsSystemDO upmsSystem){
		if(upmsSystemService.save(upmsSystem)>0){
			return R.ok();
		}
		return R.error();
	}
	
	
	@ApiOperation(value="更新系统接口", notes="更新系统接口")
	@ResponseBody
	@Log("更新系统")
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsSystem:edit")
	public R update( UpmsSystemDO upmsSystem){
		upmsSystemService.update(upmsSystem);
		return R.ok();
	}

	
	@ApiOperation(value="删除系统接口", notes="删除系统接口")
	@PostMapping( "/remove")
	@ResponseBody
	@Log("删除系统")
	@RequiresPermissions("system:upmsSystem:remove")
	public R remove( Long systemId){
		if(upmsSystemService.remove(systemId)>0){
		return R.ok();
		}
		return R.error();
	}

	@ApiOperation(value="批量删除系统信息接口", notes="批量删除系统信息接口")
	@PostMapping( "/batchRemove")
	@ResponseBody
	@Log("批量系统")
	@RequiresPermissions("system:upmsSystem:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] systemIds){
		upmsSystemService.batchRemove(systemIds);
		return R.ok();
	}
	
}
