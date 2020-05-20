package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsRolePermissionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色权限关联表
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-17 22:00:49
 */
@Mapper
public interface UpmsRolePermissionDao {

	UpmsRolePermissionDO get(Long rolePermissionId);
	
	List<UpmsRolePermissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsRolePermissionDO upmsRolePermission);
	
	int update(UpmsRolePermissionDO upmsRolePermission);
	
	int remove(Long role_permission_id);
	
	int batchRemove(Long[] rolePermissionIds);

	int batchInsert(@Param("upmsRolePermissionDOList") List<UpmsRolePermissionDO> upmsRolePermissionDOList);

	List<UpmsRolePermissionDO> selectRolePermissionByRoleId(Long roleId);

	int deleteRolePermissionByRoleId(Long roleId);

}
