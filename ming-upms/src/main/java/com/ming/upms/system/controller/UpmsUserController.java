package com.ming.upms.system.controller;

import com.ming.common.utils.MD5Utils;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.common.annotation.Log;
import com.ming.upms.common.controller.BaseController;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsUserRoleService;
import com.ming.upms.system.service.UpmsUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
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
public class UpmsUserController extends BaseController {

	@Autowired
	private UpmsUserService upmsUserService;

	@Autowired
	private UpmsUserRoleService upmsUserRoleService;
	
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
	@Log("添加用户")
	@RequiresPermissions("system:upmsUser:add")
	String add(){
	    return "system/upmsUser/add";
	}

	@GetMapping("/edit/{userId}")
	@Log("编辑用户")
	@RequiresPermissions("system:upmsUser:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		UpmsUserDO upmsUser = upmsUserService.selectUserByUserId(userId);
		model.addAttribute("upmsUser", upmsUser);
	    return "system/upmsUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@Log("保存用户")
	@RequiresPermissions("system:upmsUser:add")
	public R save( UpmsUserDO upmsUser){
		String salt = RandomStringUtils.randomAlphanumeric(30);
		upmsUser.setSalt(salt);
		String password = upmsUser.getPassword() + salt;
		upmsUser.setPassword(MD5Utils.encrypt(upmsUser.getUsername(), password));
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
	@Log("更新用户")
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
	@Log("删除用户")
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
	@Log("批量删除用户")
	@RequiresPermissions("system:upmsUser:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] userIds){
		upmsUserService.batchRemove(userIds);
		return R.ok();
	}

	@GetMapping("/personal")
	@Log("编辑用户")
	@RequiresPermissions("system:upmsUser:edit")
	public String personal(Model model){
		UpmsUserDO upmsUser = upmsUserService.selectUserByUserId(getUserId());
		model.addAttribute("user", upmsUser);
		return "system/upmsUser/personal";
	}

	@PostMapping("/checkEmailUnique")
	@ResponseBody
	public String checkEmailUnique(UpmsUserDO upmsUserDO) {
		return upmsUserService.checkEmailUnique(upmsUserDO);
	}

	@PostMapping("/checkPhoneUnique")
	@ResponseBody
	public String checkPhoneUnique(UpmsUserDO upmsUserDO) {
		return upmsUserService.checkPhoneUnique(upmsUserDO);
	}

	@PostMapping("/checkPassword")
	@ResponseBody
	public boolean checkPassword(Long userId, String password) {
		UpmsUserDO userDO = getUser();
		password += userDO.getSalt();
		password = MD5Utils.encrypt(userDO.getUsername(), password);
		if(userDO.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@PostMapping("/resetPwd")
	@ResponseBody
	public R resetPwd(UpmsUserDO user) {
		if (!getUserId().equals(user.getUserId())) {
			return R.error("非用户本人操作！");
		}
		if(StringUtils.isBlank(user.getPassword())) {
			return R.error("新密码不能为空");
		}
		UpmsUserDO userDO = getUser();
		String password = user.getPassword() + userDO.getSalt();
		user.setPassword(MD5Utils.encrypt(userDO.getUsername(), password));
		if (upmsUserService.update(user) > 0) {
			return R.ok();
		}
		return R.error("为更新数据，更新失败！");

	}


}
