package com.ming.upms.system.controller;

import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsSystemDO;
import com.ming.upms.system.service.UpmsSystemService;
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
 
@Controller
@RequestMapping("/system/upmsSystem")
public class UpmsSystemController {
	@Autowired
	private UpmsSystemService upmsSystemService;
	
	@GetMapping()
	@RequiresPermissions("system:upmsSystem:upmsSystem")
	String UpmsSystem(){
	    return "system/upmsSystem/upmsSystem";
	}
	
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
	
	@GetMapping("/add")
	@RequiresPermissions("system:upmsSystem:add")
	String add(){
	    return "system/upmsSystem/add";
	}

	@GetMapping("/edit/{systemId}")
	@RequiresPermissions("system:upmsSystem:edit")
	String edit(@PathVariable("systemId") Long systemId,Model model){
		UpmsSystemDO upmsSystem = upmsSystemService.get(systemId);
		model.addAttribute("upmsSystem", upmsSystem);
	    return "system/upmsSystem/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsSystem:add")
	public R save( UpmsSystemDO upmsSystem){
		if(upmsSystemService.save(upmsSystem)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsSystem:edit")
	public R update( UpmsSystemDO upmsSystem){
		upmsSystemService.update(upmsSystem);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsSystem:remove")
	public R remove( Long systemId){
		if(upmsSystemService.remove(systemId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsSystem:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] systemIds){
		upmsSystemService.batchRemove(systemIds);
		return R.ok();
	}
	
}
