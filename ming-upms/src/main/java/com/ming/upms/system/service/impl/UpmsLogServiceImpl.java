package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsLogDao;
import com.ming.upms.system.domain.UpmsLogDO;
import com.ming.upms.system.service.UpmsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



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

	@Async
	@Override
	public void save(UpmsLogDO upmsLog){
		upmsLogDao.save(upmsLog);
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
