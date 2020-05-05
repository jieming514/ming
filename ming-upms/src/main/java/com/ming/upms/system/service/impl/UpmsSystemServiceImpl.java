package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsSystemDao;
import com.ming.upms.system.domain.UpmsSystemDO;
import com.ming.upms.system.service.UpmsSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class UpmsSystemServiceImpl implements UpmsSystemService {
	@Autowired
	private UpmsSystemDao upmsSystemDao;
	
	@Override
	public UpmsSystemDO get(Long systemId){
		return upmsSystemDao.get(systemId);
	}
	
	@Override
	public List<UpmsSystemDO> list(Map<String, Object> map){
		return upmsSystemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsSystemDao.count(map);
	}
	
	@Override
	public int save(UpmsSystemDO upmsSystem){
		return upmsSystemDao.save(upmsSystem);
	}
	
	@Override
	public int update(UpmsSystemDO upmsSystem){
		return upmsSystemDao.update(upmsSystem);
	}
	
	@Override
	public int remove(Long systemId){
		return upmsSystemDao.remove(systemId);
	}
	
	@Override
	public int batchRemove(Long[] systemIds){
		return upmsSystemDao.batchRemove(systemIds);
	}

	/**
	 * 获取有效的列表
	 * @param map
	 * @return
	 */
	@Override
	public List<UpmsSystemDO> getAvalidList(Map<String, Object> map) {
		map.put("status", 1);
		return list(map);
	}

}
