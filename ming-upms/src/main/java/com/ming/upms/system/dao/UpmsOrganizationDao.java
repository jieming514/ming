package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsOrganizationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 组织
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 14:29:52
 */
@Mapper
public interface UpmsOrganizationDao {

	UpmsOrganizationDO get(Long organizationId);
	
	List<UpmsOrganizationDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsOrganizationDO upmsOrganization);
	
	int update(UpmsOrganizationDO upmsOrganization);
	
	int remove(Long organizationId);
	
	int batchRemove(Long[] organizationIds);

	UpmsOrganizationDO getOrganizationById(Long organizationId);
}
