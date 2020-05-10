package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsUserOrganizationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户组织关联表
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-10 14:20:51
 */
@Mapper
public interface UpmsUserOrganizationDao {

	UpmsUserOrganizationDO get(Integer userOrganizationId);
	
	List<UpmsUserOrganizationDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsUserOrganizationDO upmsUserOrganization);
	
	int update(UpmsUserOrganizationDO upmsUserOrganization);
	
	int remove(Integer user_organization_id);
	
	int batchRemove(Integer[] userOrganizationIds);
}
