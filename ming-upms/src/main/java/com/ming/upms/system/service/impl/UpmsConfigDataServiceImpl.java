package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsConfigDataDao;
import com.ming.upms.system.domain.UpmsConfigDataDO;
import com.ming.upms.system.service.UpmsConfigDataService;



@Service
public class UpmsConfigDataServiceImpl implements UpmsConfigDataService {
	@Autowired
	private UpmsConfigDataDao upmsConfigDataDao;
	
	@Override
	public UpmsConfigDataDO get(Long configId){
		return upmsConfigDataDao.get(configId);
	}
	
	@Override
	public List<UpmsConfigDataDO> list(Map<String, Object> map){
		return upmsConfigDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsConfigDataDao.count(map);
	}
	
	@Override
	public int save(UpmsConfigDataDO upmsConfigData){
		return upmsConfigDataDao.save(upmsConfigData);
	}
	
	@Override
	public int update(UpmsConfigDataDO upmsConfigData){
		return upmsConfigDataDao.update(upmsConfigData);
	}
	
	@Override
	public int remove(Long configId){
		return upmsConfigDataDao.remove(configId);
	}
	
	@Override
	public int batchRemove(Long[] configIds){
		return upmsConfigDataDao.batchRemove(configIds);
	}
	
}
