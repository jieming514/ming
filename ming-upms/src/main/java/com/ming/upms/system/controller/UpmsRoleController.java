package com.ming.upms.system.controller;

import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.common.annotation.Log;
import com.ming.upms.system.domain.UpmsRoleDO;
import com.ming.upms.system.domain.UpmsRolePermissionDO;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsRolePermissionService;
import com.ming.upms.system.service.UpmsRoleService;
import com.ming.upms.system.service.UpmsUserRoleService;
import com.ming.upms.system.service.UpmsUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	private static final Logger logger = LoggerFactory.getLogger(UpmsRoleController.class);

	@Autowired
	private UpmsRoleService upmsRoleService;

	@Autowired
	private UpmsRolePermissionService upmsRolePermissionService;

	@Autowired
	private UpmsUserRoleService upmsUserRoleService;

	@Autowired
	private UpmsUserService upmsUserService;

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
	@Log("添加角色")
	String add(){
	    return "system/upmsRole/add";
	}

	@GetMapping("/edit/{roleId}")
	@RequiresPermissions("system:upmsRole:edit")
	@Log("编辑角色")
	String edit(@PathVariable("roleId") Long roleId,Model model){
		UpmsRoleDO upmsRole = upmsRoleService.get(roleId);
		model.addAttribute("upmsRole", upmsRole);
	    return "system/upmsRole/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@Log("保存角色")
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
	@Log("修改角色")
	@RequiresPermissions("system:upmsRole:edit")
	public R update( UpmsRoleDO upmsRole, Long[] permissionArr){
		List<UpmsRolePermissionDO> upmsRolePermissionDOList = new ArrayList<UpmsRolePermissionDO>();
		upmsRoleService.update(upmsRole);
		upmsRolePermissionService.deleteRolePermissionByRoleId(upmsRole.getRoleId());
		for (Long permission : permissionArr) {
			UpmsRolePermissionDO upmsRolePermissionDO = new UpmsRolePermissionDO();
			upmsRolePermissionDO.setRoleId(upmsRole.getRoleId());
			upmsRolePermissionDO.setPermissionId(permission);
			upmsRolePermissionDOList.add(upmsRolePermissionDO);
		}
		upmsRolePermissionService.batchInsert(upmsRolePermissionDOList);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@Log("删除角色")
	@RequiresPermissions("system:upmsRole:remove")
	public R remove( Long roleId){
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
	@Log("批量删除角色")
	@RequiresPermissions("system:upmsRole:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] roleIds){
		upmsRoleService.batchRemove(roleIds);
		return R.ok();
	}

	/**
	 * 角色授权用户页面
	 * @return
	 */
	@GetMapping("/authRole/{roleId}")
	@RequiresPermissions("system:upmsRole:upmsRole")
	public String authRole(@PathVariable("roleId") Long roleId, Model model) {
		UpmsRoleDO upmsRoleDO = upmsRoleService.get(roleId);
		model.addAttribute("upmsRoleDO", upmsRoleDO);
		return "system/upmsRole/authUser";
	}

	@PostMapping("/selectAuthRoleUser/{roleId}")
	@RequiresPermissions("system:upmsRole:upmsRole")
	@ResponseBody
	public List<UpmsUserDO> selectAuthRoleUserByRoleId(@PathVariable("roleId") Long roleId,
													   @RequestParam Map<String, Object> params) {
		params.put("roleId", roleId);
		return upmsUserService.selectUserByRole(params);
	}


	@PostMapping("/deleteUserRoleInfo")
	@Log("删除角色的用户")
	@ResponseBody
	public R deleteUserRoleInfo(Long roleId, Long userId) {
		if(upmsUserRoleService.deleteUserRoleInfo(roleId, userId) > 0) {
			return R.ok();
		}
		return R.error("删除角色的用户失败");
	}
	
}
