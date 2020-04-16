package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsRoleDao;
import com.ming.upms.system.domain.UpmsRoleDO;
import com.ming.upms.system.service.UpmsRoleService;



@Service
public class UpmsRoleServiceImpl implements UpmsRoleService {
	@Autowired
	private UpmsRoleDao upmsRoleDao;
	
	@Override
	public UpmsRoleDO get(Integer roleId){
		return upmsRoleDao.get(roleId);
	}
	
	@Override
	public List<UpmsRoleDO> list(Map<String, Object> map){
		return upmsRoleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsRoleDao.count(map);
	}
	
	@Override
	public int save(UpmsRoleDO upmsRole){
		return upmsRoleDao.save(upmsRole);
	}
	
	@Override
	public int update(UpmsRoleDO upmsRole){
		return upmsRoleDao.update(upmsRole);
	}
	
	@Override
	public int remove(Integer roleId){
		return upmsRoleDao.remove(roleId);
	}
	
	@Override
	public int batchRemove(Integer[] roleIds){
		return upmsRoleDao.batchRemove(roleIds);
	}
	
}
