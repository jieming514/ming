package com.ming.upms.system.service;

import com.ming.upms.common.domain.Tree;
import com.ming.upms.system.domain.UpmsPermissionDO;

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
	
	UpmsPermissionDO get(Long permissionId);
	
	List<UpmsPermissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsPermissionDO upmsPermission);
	
	int update(UpmsPermissionDO upmsPermission);
	
	int remove(Long permissionId);
	
	int batchRemove(Long[] permissionIds);

	Set<String> getPermsByUserId(Long userId);

	List<UpmsPermissionDO> selectPermissionByUserId(Long userId);

	List<Tree<UpmsPermissionDO>> getTreeByUserId(Long userId);

	List<UpmsPermissionDO> getSystemPermissionList(Map<String,Object> map);

	List<UpmsPermissionDO> selectPermissionByRoleId(Long roleId);

	List<Tree<UpmsPermissionDO>> getTree(Long roleId);

	List<UpmsPermissionDO> selectRoleHasPermissionByRoleId(Long roleId);
}
