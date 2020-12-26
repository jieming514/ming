package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsConfigTypeDao;
import com.ming.upms.system.domain.UpmsConfigTypeDO;
import com.ming.upms.system.service.UpmsConfigTypeService;



@Service
public class UpmsConfigTypeServiceImpl implements UpmsConfigTypeService {
	@Autowired
	private UpmsConfigTypeDao upmsConfigTypeDao;
	
	@Override
	public UpmsConfigTypeDO get(Long configTypeId){
		return upmsConfigTypeDao.get(configTypeId);
	}
	
	@Override
	public List<UpmsConfigTypeDO> list(Map<String, Object> map){
		return upmsConfigTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsConfigTypeDao.count(map);
	}
	
	@Override
	public int save(UpmsConfigTypeDO upmsConfigType){
		return upmsConfigTypeDao.save(upmsConfigType);
	}
	
	@Override
	public int update(UpmsConfigTypeDO upmsConfigType){
		return upmsConfigTypeDao.update(upmsConfigType);
	}
	
	@Override
	public int remove(Long configTypeId){
		return upmsConfigTypeDao.remove(configTypeId);
	}
	
	@Override
	public int batchRemove(Long[] configTypeIds){
		return upmsConfigTypeDao.batchRemove(configTypeIds);
	}
	
}
