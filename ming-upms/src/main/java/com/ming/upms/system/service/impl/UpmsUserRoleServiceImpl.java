package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsUserRoleDao;
import com.ming.upms.system.domain.UpmsUserRoleDO;
import com.ming.upms.system.service.UpmsUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class UpmsUserRoleServiceImpl implements UpmsUserRoleService {
	@Autowired
	private UpmsUserRoleDao upmsUserRoleDao;
	
	@Override
	public UpmsUserRoleDO get(Integer userRoleId){
		return upmsUserRoleDao.get(userRoleId);
	}
	
	@Override
	public List<UpmsUserRoleDO> list(Map<String, Object> map){
		return upmsUserRoleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsUserRoleDao.count(map);
	}
	
	@Override
	public int save(UpmsUserRoleDO upmsUserRole){
		return upmsUserRoleDao.save(upmsUserRole);
	}
	
	@Override
	public int update(UpmsUserRoleDO upmsUserRole){
		return upmsUserRoleDao.update(upmsUserRole);
	}
	
	@Override
	public int remove(Integer userRoleId){
		return upmsUserRoleDao.remove(userRoleId);
	}
	
	@Override
	public int batchRemove(Integer[] userRoleIds){
		return upmsUserRoleDao.batchRemove(userRoleIds);
	}

	@Override
	public List<UpmsUserRoleDO> selectUserRoleByUserId(Long userId) {
		return upmsUserRoleDao.selectUserRoleByUserId(userId);
	}

	@Override
	public List<UpmsUserRoleDO> selectUserRoleByroleId(Long roleId) {
		return upmsUserRoleDao.selectUserRoleByroleId(roleId);
	}

}
