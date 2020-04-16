package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsPermissionDO;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

/**
 * 权限
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 15:17:30
 */
@Mapper
public interface UpmsPermissionDao {

	UpmsPermissionDO get(Integer permissionId);
	
	List<UpmsPermissionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsPermissionDO upmsPermission);
	
	int update(UpmsPermissionDO upmsPermission);
	
	int remove(Integer permission_id);
	
	int batchRemove(Integer[] permissionIds);

	Set<UpmsPermissionDO> getByUserId(Integer userId);

	Set<String> getPermsByUserId(Integer userId);
}
