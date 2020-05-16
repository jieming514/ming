package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsPermissionDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 权限
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 15:17:30
 */
@Mapper
public interface UpmsPermissionDao {

	UpmsPermissionDO get(Long permissionId);
	
	List<UpmsPermissionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsPermissionDO upmsPermission);
	
	int update(UpmsPermissionDO upmsPermission);
	
	int remove(Long permissionId);
	
	int batchRemove(Long[] permissionIds);

	Set<String> getPermsByUserId(Long userId);

	List<UpmsPermissionDO> selectPermissionByUserId(Long userId);

	List<UpmsPermissionDO> selectPermissionByRoleId(Long roleId);

	List<UpmsPermissionDO> getSystemPermissionList(Map<String,Object> map);

}
