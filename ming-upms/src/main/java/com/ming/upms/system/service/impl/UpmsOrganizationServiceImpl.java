package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsOrganizationDao;
import com.ming.upms.system.domain.UpmsOrganizationDO;
import com.ming.upms.system.service.UpmsOrganizationService;



@Service
public class UpmsOrganizationServiceImpl implements UpmsOrganizationService {
	@Autowired
	private UpmsOrganizationDao upmsOrganizationDao;
	
	@Override
	public UpmsOrganizationDO get(Integer organizationId){
		return upmsOrganizationDao.get(organizationId);
	}
	
	@Override
	public List<UpmsOrganizationDO> list(Map<String, Object> map){
		return upmsOrganizationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsOrganizationDao.count(map);
	}
	
	@Override
	public int save(UpmsOrganizationDO upmsOrganization){
		return upmsOrganizationDao.save(upmsOrganization);
	}
	
	@Override
	public int update(UpmsOrganizationDO upmsOrganization){
		return upmsOrganizationDao.update(upmsOrganization);
	}
	
	@Override
	public int remove(Integer organizationId){
		return upmsOrganizationDao.remove(organizationId);
	}
	
	@Override
	public int batchRemove(Integer[] organizationIds){
		return upmsOrganizationDao.batchRemove(organizationIds);
	}
	
}
