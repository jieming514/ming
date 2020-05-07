package com.ming.upms.system.controller;

import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsPermissionDO;
import com.ming.upms.system.domain.UpmsSystemDO;
import com.ming.upms.system.service.UpmsPermissionService;
import com.ming.upms.system.service.UpmsSystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 15:17:30
 */
 
@Controller
@RequestMapping("/system/upmsPermission")
public class UpmsPermissionController {
	@Autowired
	private UpmsPermissionService upmsPermissionService;

	@Autowired
	private UpmsSystemService upmsSystemService;

	
	@GetMapping()
	@RequiresPermissions("system:upmsPermission:upmsPermission")
	String UpmsPermission(){
	    return "system/upmsPermission/upmsPermission";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsPermission:upmsPermission")
	public List<UpmsPermissionDO> list(@RequestParam Map<String, Object> params){
		//List<UpmsPermissionDO> upmsPermissionList = upmsPermissionService.list(params);
		List<UpmsPermissionDO> upmsPermissionList = upmsPermissionService.getSystemPermissionList(params);
		return upmsPermissionList;
	}
	
	@GetMapping("/add/{pid}")
	@RequiresPermissions("system:upmsPermission:add")
	String add(@PathVariable("pid") Long pid, Model model){
		List<UpmsSystemDO> systemList = upmsSystemService.getAvalidList(new HashMap<>());
		UpmsPermissionDO pPermissionDO = upmsPermissionService.get(pid);
		if(pPermissionDO == null || pPermissionDO.getPermissionId() == null) {
			pPermissionDO = new UpmsPermissionDO();
			pPermissionDO.setPermissionId(0L);
			pPermissionDO.setName("根目录");
		}
		model.addAttribute("systemList", systemList);
		model.addAttribute("pPermissionDO", pPermissionDO);
		return "system/upmsPermission/add";
	}

	@GetMapping("/edit/{permissionId}")
	@RequiresPermissions("system:upmsPermission:edit")
	String edit(@PathVariable("permissionId") Long permissionId,Model model){
		UpmsPermissionDO upmsPermission = upmsPermissionService.get(permissionId);
		List<UpmsSystemDO> systemList = upmsSystemService.getAvalidList(new HashMap<>());
		UpmsPermissionDO pPermissionDO = upmsPermissionService.get(upmsPermission.getPid());
		if(pPermissionDO == null || pPermissionDO.getPermissionId() == null) {
			pPermissionDO = new UpmsPermissionDO();
			pPermissionDO.setPermissionId(0L);
			pPermissionDO.setName("根目录");
		}
		model.addAttribute("upmsPermission", upmsPermission);
		model.addAttribute("pPermissionDO", pPermissionDO);
		model.addAttribute("systemList", systemList);
	    return "system/upmsPermission/edit";
	}

	@GetMapping("/icon")
	String icon() {
		return "system/upmsPermission/icon";
	}


	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsPermission:add")
	public R save( UpmsPermissionDO upmsPermission){
		if(upmsPermissionService.save(upmsPermission)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsPermission:edit")
	public R update( UpmsPermissionDO upmsPermission){
		upmsPermissionService.update(upmsPermission);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsPermission:remove")
	public R remove( Long permissionId){
		if(upmsPermissionService.remove(permissionId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsPermission:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] permissionIds){
		upmsPermissionService.batchRemove(permissionIds);
		return R.ok();
	}
	
}
