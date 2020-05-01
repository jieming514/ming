package com.ming.upms.system.controller;

import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-01 15:23:25
 */
 
@Controller
@RequestMapping("/system/upmsUser")
public class UpmsUserController {
	@Autowired
	private UpmsUserService upmsUserService;
	
	@GetMapping()
	@RequiresPermissions("system:upmsUser:upmsUser")
	String UpmsUser(){
	    return "system/upmsUser/upmsUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsUser:upmsUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UpmsUserDO> upmsUserList = upmsUserService.list(query);
		int total = upmsUserService.count(query);
		PageUtils pageUtils = new PageUtils(upmsUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:upmsUser:add")
	String add(){
	    return "system/upmsUser/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("system:upmsUser:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		UpmsUserDO upmsUser = upmsUserService.get(userId);
		model.addAttribute("upmsUser", upmsUser);
	    return "system/upmsUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsUser:add")
	public R save( UpmsUserDO upmsUser){
		if(upmsUserService.save(upmsUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsUser:edit")
	public R update( UpmsUserDO upmsUser){
		upmsUserService.update(upmsUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsUser:remove")
	public R remove( Long userId){
		if(upmsUserService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsUser:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] userIds){
		upmsUserService.batchRemove(userIds);
		return R.ok();
	}
	
}