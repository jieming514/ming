package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsUserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 用户角色关联表
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-17 22:03:25
 */
public interface UpmsUserRoleService {
	
	UpmsUserRoleDO get(Integer userRoleId);
	
	List<UpmsUserRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsUserRoleDO upmsUserRole);
	
	int update(UpmsUserRoleDO upmsUserRole);
	
	int remove(Integer userRoleId);
	
	int batchRemove(Integer[] userRoleIds);


	/**
	 * 通过用户名查询用户角色
	 * @param userId
	 * @return
	 */
	List<UpmsUserRoleDO> selectUserRoleByUserId(Long userId);

	/**
	 * 通过用户名查询用户角色
	 * @param roleId
	 * @return
	 */
	List<UpmsUserRoleDO> selectUserRoleByroleId(Long roleId);

	/**
	 * 删除用户角色关系
	 * @param roleId
	 * @param userId
	 * @return
	 */
	int deleteUserRoleInfo(Long roleId, Long userId);

	/**
	 * 批量添加
	 * @param roleId
	 * @param userIds
	 * @return
	 */
	int batchAddRole(Long roleId, Long[] userIds);

	/**
	 * 批量删除
	 * @param roleId
	 * @param userIds
	 * @return
	 */
	int batchRemoveRole(Long roleId, Long[] userIds);
}
