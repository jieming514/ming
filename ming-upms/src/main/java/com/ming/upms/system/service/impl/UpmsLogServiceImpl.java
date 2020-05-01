package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsLogDao;
import com.ming.upms.system.domain.UpmsLogDO;
import com.ming.upms.system.service.UpmsLogService;



@Service
public class UpmsLogServiceImpl implements UpmsLogService {
	@Autowired
	private UpmsLogDao upmsLogDao;
	
	@Override
	public UpmsLogDO get(Long logId){
		return upmsLogDao.get(logId);
	}
	
	@Override
	public List<UpmsLogDO> list(Map<String, Object> map){
		return upmsLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsLogDao.count(map);
	}
	
	@Override
	public int save(UpmsLogDO upmsLog){
		return upmsLogDao.save(upmsLog);
	}
	
	@Override
	public int update(UpmsLogDO upmsLog){
		return upmsLogDao.update(upmsLog);
	}
	
	@Override
	public int remove(Long logId){
		return upmsLogDao.remove(logId);
	}
	
	@Override
	public int batchRemove(Long[] logIds){
		return upmsLogDao.batchRemove(logIds);
	}
	
}
