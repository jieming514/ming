package com.ming.upms.system.service;

import com.ming.upms.common.domain.Tree;
import com.ming.upms.system.domain.UpmsOrganizationDO;

import java.util.List;
import java.util.Map;

/**
 * 组织
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 14:29:52
 */
public interface UpmsOrganizationService {
	
	UpmsOrganizationDO get(Long organizationId);
	
	List<UpmsOrganizationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsOrganizationDO upmsOrganization);
	
	int update(UpmsOrganizationDO upmsOrganization);
	
	int remove(Long organizationId);
	
	int batchRemove(Long[] organizationIds);

	UpmsOrganizationDO getOrganizationById(Long organizationId);

	/**
	 * 获取完整的机构数
	 * @return
	 */
	Tree<UpmsOrganizationDO> getTree();

}
