package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsRolePermissionDao;
import com.ming.upms.system.domain.UpmsRolePermissionDO;
import com.ming.upms.system.service.UpmsRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class UpmsRolePermissionServiceImpl implements UpmsRolePermissionService {
	@Autowired
	private UpmsRolePermissionDao upmsRolePermissionDao;
	
	@Override
	public UpmsRolePermissionDO get(Long rolePermissionId){
		return upmsRolePermissionDao.get(rolePermissionId);
	}
	
	@Override
	public List<UpmsRolePermissionDO> list(Map<String, Object> map){
		return upmsRolePermissionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsRolePermissionDao.count(map);
	}
	
	@Override
	public int save(UpmsRolePermissionDO upmsRolePermission){
		return upmsRolePermissionDao.save(upmsRolePermission);
	}
	
	@Override
	public int update(UpmsRolePermissionDO upmsRolePermission){
		return upmsRolePermissionDao.update(upmsRolePermission);
	}
	
	@Override
	public int remove(Long rolePermissionId){
		return upmsRolePermissionDao.remove(rolePermissionId);
	}
	
	@Override
	public int batchRemove(Long[] rolePermissionIds){
		return upmsRolePermissionDao.batchRemove(rolePermissionIds);
	}

	@Override
	public int batchInsert(List<UpmsRolePermissionDO> upmsRolePermissionDOList) {
		return upmsRolePermissionDao.batchInsert(upmsRolePermissionDOList);
	}

	@Override
	public List<UpmsRolePermissionDO> selectRolePermissionByRoleId(Long roleId) {
		return upmsRolePermissionDao.selectRolePermissionByRoleId(roleId);
	}

	@Override
	public int deleteRolePermissionByRoleId(Long roleId) {
		return upmsRolePermissionDao.deleteRolePermissionByRoleId(roleId);
	}

}
