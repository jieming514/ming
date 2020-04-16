package com.ming.upms.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.upms.system.domain.UpmsRoleDO;
import com.ming.upms.system.service.UpmsRoleService;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;

/**
 * 角色
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-11 20:08:05
 */
 
@Controller
@RequestMapping("/system/upmsRole")
public class UpmsRoleController {
	@Autowired
	private UpmsRoleService upmsRoleService;
	
	@GetMapping()
	@RequiresPermissions("system:upmsRole:upmsRole")
	String UpmsRole(){
	    return "system/upmsRole/upmsRole";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsRole:upmsRole")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UpmsRoleDO> upmsRoleList = upmsRoleService.list(query);
		int total = upmsRoleService.count(query);
		PageUtils pageUtils = new PageUtils(upmsRoleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:upmsRole:add")
	String add(){
	    return "system/upmsRole/add";
	}

	@GetMapping("/edit/{roleId}")
	@RequiresPermissions("system:upmsRole:edit")
	String edit(@PathVariable("roleId") Integer roleId,Model model){
		UpmsRoleDO upmsRole = upmsRoleService.get(roleId);
		model.addAttribute("upmsRole", upmsRole);
	    return "system/upmsRole/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsRole:add")
	public R save( UpmsRoleDO upmsRole){
		if(upmsRoleService.save(upmsRole)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsRole:edit")
	public R update( UpmsRoleDO upmsRole){
		upmsRoleService.update(upmsRole);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsRole:remove")
	public R remove( Integer roleId){
		if(upmsRoleService.remove(roleId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsRole:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] roleIds){
		upmsRoleService.batchRemove(roleIds);
		return R.ok();
	}
	
}
