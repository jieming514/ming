package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsRolePermissionDO;

import java.util.List;
import java.util.Map;

/**
 * 角色权限关联表
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-17 22:00:49
 */
public interface UpmsRolePermissionService {
	
	UpmsRolePermissionDO get(Integer rolePermissionId);
	
	List<UpmsRolePermissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsRolePermissionDO upmsRolePermission);
	
	int update(UpmsRolePermissionDO upmsRolePermission);
	
	int remove(Integer rolePermissionId);
	
	int batchRemove(Integer[] rolePermissionIds);

}
