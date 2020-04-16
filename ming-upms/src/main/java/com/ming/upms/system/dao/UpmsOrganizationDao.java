package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsOrganizationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 组织
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 14:29:52
 */
@Mapper
public interface UpmsOrganizationDao {

	UpmsOrganizationDO get(Integer organizationId);
	
	List<UpmsOrganizationDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsOrganizationDO upmsOrganization);
	
	int update(UpmsOrganizationDO upmsOrganization);
	
	int remove(Integer organization_id);
	
	int batchRemove(Integer[] organizationIds);
}
