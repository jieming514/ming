package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ming.upms.system.dao.UpmsPermissionDao;
import com.ming.upms.system.domain.UpmsPermissionDO;
import com.ming.upms.system.service.UpmsPermissionService;



@Service
public class UpmsPermissionServiceImpl implements UpmsPermissionService {
	@Autowired
	private UpmsPermissionDao upmsPermissionDao;
	
	@Override
	public UpmsPermissionDO get(Integer permissionId){
		return upmsPermissionDao.get(permissionId);
	}
	
	@Override
	public List<UpmsPermissionDO> list(Map<String, Object> map){
		return upmsPermissionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsPermissionDao.count(map);
	}
	
	@Override
	public int save(UpmsPermissionDO upmsPermission){
		return upmsPermissionDao.save(upmsPermission);
	}
	
	@Override
	public int update(UpmsPermissionDO upmsPermission){
		return upmsPermissionDao.update(upmsPermission);
	}
	
	@Override
	public int remove(Integer permissionId){
		return upmsPermissionDao.remove(permissionId);
	}
	
	@Override
	public int batchRemove(Integer[] permissionIds){
		return upmsPermissionDao.batchRemove(permissionIds);
	}

	/**
	 * 通过用户ID查找权限信息
	 * @param userId
	 * @return
	 */
	@Override
	public Set<UpmsPermissionDO> getByUserId(Integer userId) {
		return upmsPermissionDao.getByUserId(userId);
	}

	@Override
	public Set<String> getPermsByUserId(Integer userId) {
		return upmsPermissionDao.getPermsByUserId(userId);
	}

}
