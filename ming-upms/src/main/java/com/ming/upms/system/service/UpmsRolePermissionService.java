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
	
	UpmsRolePermissionDO get(Long rolePermissionId);
	
	List<UpmsRolePermissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsRolePermissionDO upmsRolePermission);
	
	int update(UpmsRolePermissionDO upmsRolePermission);
	
	int remove(Long rolePermissionId);
	
	int batchRemove(Long[] rolePermissionIds);

	int batchInsert(List<UpmsRolePermissionDO> upmsRolePermissionDOList);

	/**
	 * 通过角色ID查找角色权限关系
	 * @param roleId
	 * @return
	 */
	List<UpmsRolePermissionDO> selectRolePermissionByRoleId(Long roleId);

	/**
	 * 通过角色ID删除角色权限关系
	 * @param roleId
	 * @return
	 */
	int deleteRolePermissionByRoleId(Long roleId);

}
