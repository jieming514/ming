package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsUserOrganizationDO;

import java.util.List;
import java.util.Map;

/**
 * 用户组织关联表
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-10 14:20:51
 */
public interface UpmsUserOrganizationService {
	
	UpmsUserOrganizationDO get(Integer userOrganizationId);
	
	List<UpmsUserOrganizationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsUserOrganizationDO upmsUserOrganization);
	
	int update(UpmsUserOrganizationDO upmsUserOrganization);
	
	int remove(Integer userOrganizationId);
	
	int batchRemove(Integer[] userOrganizationIds);
}
