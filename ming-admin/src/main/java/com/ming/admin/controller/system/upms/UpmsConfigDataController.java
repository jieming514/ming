package com.ming.admin.controller.system.upms;

import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsConfigDataDO;
import com.ming.upms.system.service.UpmsConfigDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 参数配置明细表
 * 
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2020-12-20 23:44:19
 */
 
@Controller
@RequestMapping("/system/upmsConfigData")
public class UpmsConfigDataController {
	@Autowired
	private UpmsConfigDataService upmsConfigDataService;
	
	@GetMapping()
	@RequiresPermissions("system:upmsConfigData:upmsConfigData")
	String UpmsConfigData(){
	    return "system/upmsConfigData/upmsConfigData";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsConfigData:upmsConfigData")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UpmsConfigDataDO> upmsConfigDataList = upmsConfigDataService.list(query);
		int total = upmsConfigDataService.count(query);
		PageUtils pageUtils = new PageUtils(upmsConfigDataList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:upmsConfigData:add")
	String add(){
	    return "system/upmsConfigData/add";
	}

	@GetMapping("/edit/{configId}")
	@RequiresPermissions("system:upmsConfigData:edit")
	String edit(@PathVariable("configId") Long configId,Model model){
		UpmsConfigDataDO upmsConfigData = upmsConfigDataService.get(configId);
		model.addAttribute("upmsConfigData", upmsConfigData);
	    return "system/upmsConfigData/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsConfigData:add")
	public R save( UpmsConfigDataDO upmsConfigData){
		if(upmsConfigDataService.save(upmsConfigData)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsConfigData:edit")
	public R update( UpmsConfigDataDO upmsConfigData){
		upmsConfigDataService.update(upmsConfigData);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsConfigData:remove")
	public R remove( Long configId){
		if(upmsConfigDataService.remove(configId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsConfigData:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] configIds){
		upmsConfigDataService.batchRemove(configIds);
		return R.ok();
	}
	
}
