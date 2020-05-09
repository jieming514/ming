package com.ming.upms.system.controller;

import com.ming.common.utils.R;
import com.ming.upms.common.domain.Tree;
import com.ming.upms.system.domain.UpmsOrganizationDO;
import com.ming.upms.system.service.UpmsOrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 组织
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 14:29:52
 */
 
@Controller
@RequestMapping("/system/upmsOrganization")
public class UpmsOrganizationController {
	@Autowired
	private UpmsOrganizationService upmsOrganizationService;
	
	@GetMapping()
	//@RequiresPermissions("system:upmsOrganization:upmsOrganization")
	public String UpmsOrganization(){
	    return "system/upmsOrganization/upmsOrganization";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsOrganization:upmsOrganization")
	public List<UpmsOrganizationDO> list(@RequestParam Map<String, Object> params){
		List<UpmsOrganizationDO> upmsOrganizationList = upmsOrganizationService.list(params);
		return upmsOrganizationList;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:upmsOrganization:add")
	String add(){
	    return "system/upmsOrganization/add";
	}

	@GetMapping("/edit/{organizationId}")
	@RequiresPermissions("system:upmsOrganization:edit")
	String edit(@PathVariable("organizationId") Long organizationId,Model model){
		UpmsOrganizationDO upmsOrganization = upmsOrganizationService.getOrganizationById(organizationId);
		model.addAttribute("upmsOrganization", upmsOrganization);
	    return "system/upmsOrganization/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsOrganization:add")
	public R save( UpmsOrganizationDO upmsOrganization){
		if(upmsOrganizationService.save(upmsOrganization)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsOrganization:edit")
	public R update( UpmsOrganizationDO upmsOrganization){
		upmsOrganizationService.update(upmsOrganization);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsOrganization:remove")
	public R remove( Long organizationId){
		if(upmsOrganizationService.remove(organizationId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsOrganization:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] organizationIds){
		upmsOrganizationService.batchRemove(organizationIds);
		return R.ok();
	}

	@GetMapping("/getOrganizationTree")
	@RequiresPermissions("system:upmsOrganization:read")
	public String getOrganizationTree() {
		return "system/upmsOrganization/tree";
	}

	@ResponseBody
	@PostMapping("/getTree")
	public Tree<UpmsOrganizationDO> getTree() {
		Tree<UpmsOrganizationDO> tree = new Tree<UpmsOrganizationDO>();
		tree = upmsOrganizationService.getTree();
		return tree;
	}
	
}
