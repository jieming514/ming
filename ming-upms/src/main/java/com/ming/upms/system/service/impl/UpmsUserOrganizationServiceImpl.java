package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsUserOrganizationDao;
import com.ming.upms.system.domain.UpmsUserOrganizationDO;
import com.ming.upms.system.service.UpmsUserOrganizationService;



@Service
public class UpmsUserOrganizationServiceImpl implements UpmsUserOrganizationService {
	@Autowired
	private UpmsUserOrganizationDao upmsUserOrganizationDao;
	
	@Override
	public UpmsUserOrganizationDO get(Integer userOrganizationId){
		return upmsUserOrganizationDao.get(userOrganizationId);
	}
	
	@Override
	public List<UpmsUserOrganizationDO> list(Map<String, Object> map){
		return upmsUserOrganizationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsUserOrganizationDao.count(map);
	}
	
	@Override
	public int save(UpmsUserOrganizationDO upmsUserOrganization){
		return upmsUserOrganizationDao.save(upmsUserOrganization);
	}
	
	@Override
	public int update(UpmsUserOrganizationDO upmsUserOrganization){
		return upmsUserOrganizationDao.update(upmsUserOrganization);
	}
	
	@Override
	public int remove(Integer userOrganizationId){
		return upmsUserOrganizationDao.remove(userOrganizationId);
	}
	
	@Override
	public int batchRemove(Integer[] userOrganizationIds){
		return upmsUserOrganizationDao.batchRemove(userOrganizationIds);
	}
	
}
