package com.ming.admin.controller.system.upms;

import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsConfigTypeDO;
import com.ming.upms.system.service.UpmsConfigTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 参数配置类型表
 * 
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2020-12-20 23:39:54
 */
 
@Controller
@RequestMapping("/system/upmsConfigType")
public class UpmsConfigTypeController {
	@Autowired
	private UpmsConfigTypeService upmsConfigTypeService;
	
	@GetMapping()
	@RequiresPermissions("system:upmsConfigType:upmsConfigType")
	String UpmsConfigType(){
	    return "system/upmsConfigType/upmsConfigType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsConfigType:upmsConfigType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UpmsConfigTypeDO> upmsConfigTypeList = upmsConfigTypeService.list(query);
		int total = upmsConfigTypeService.count(query);
		PageUtils pageUtils = new PageUtils(upmsConfigTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:upmsConfigType:add")
	String add(){
	    return "system/upmsConfigType/add";
	}

	@GetMapping("/edit/{configTypeId}")
	@RequiresPermissions("system:upmsConfigType:edit")
	String edit(@PathVariable("configTypeId") Long configTypeId,Model model){
		UpmsConfigTypeDO upmsConfigType = upmsConfigTypeService.get(configTypeId);
		model.addAttribute("upmsConfigType", upmsConfigType);
	    return "system/upmsConfigType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsConfigType:add")
	public R save( UpmsConfigTypeDO upmsConfigType){
		if(upmsConfigTypeService.save(upmsConfigType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsConfigType:edit")
	public R update( UpmsConfigTypeDO upmsConfigType){
		upmsConfigTypeService.update(upmsConfigType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsConfigType:remove")
	public R remove( Long configTypeId){
		if(upmsConfigTypeService.remove(configTypeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsConfigType:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] configTypeIds){
		upmsConfigTypeService.batchRemove(configTypeIds);
		return R.ok();
	}
	
}
