package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsUserRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户角色关联表
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-17 22:03:25
 */
@Mapper
public interface UpmsUserRoleDao {

	UpmsUserRoleDO get(Integer userRoleId);
	
	List<UpmsUserRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsUserRoleDO upmsUserRole);
	
	int update(UpmsUserRoleDO upmsUserRole);
	
	int remove(Integer user_role_id);
	
	int batchRemove(Integer[] userRoleIds);
}
