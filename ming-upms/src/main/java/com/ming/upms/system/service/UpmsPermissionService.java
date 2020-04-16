package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsPermissionDO;
import javafx.scene.effect.SepiaTone;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 权限
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 15:17:30
 */
public interface UpmsPermissionService {
	
	UpmsPermissionDO get(Integer permissionId);
	
	List<UpmsPermissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsPermissionDO upmsPermission);
	
	int update(UpmsPermissionDO upmsPermission);
	
	int remove(Integer permissionId);
	
	int batchRemove(Integer[] permissionIds);

	Set<UpmsPermissionDO> getByUserId(Integer userId);

	Set<String> getPermsByUserId(Integer userId);
}
