package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsDictDataDao;
import com.ming.upms.system.domain.UpmsDictDataDO;
import com.ming.upms.system.service.UpmsDictDataService;



@Service
public class UpmsDictDataServiceImpl implements UpmsDictDataService {
	@Autowired
	private UpmsDictDataDao upmsDictDataDao;
	
	@Override
	public UpmsDictDataDO get(Long dictCode){
		return upmsDictDataDao.get(dictCode);
	}
	
	@Override
	public List<UpmsDictDataDO> list(Map<String, Object> map){
		return upmsDictDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsDictDataDao.count(map);
	}
	
	@Override
	public int save(UpmsDictDataDO upmsDictData){
		return upmsDictDataDao.save(upmsDictData);
	}
	
	@Override
	public int update(UpmsDictDataDO upmsDictData){
		return upmsDictDataDao.update(upmsDictData);
	}
	
	@Override
	public int remove(Long dictCode){
		return upmsDictDataDao.remove(dictCode);
	}
	
	@Override
	public int batchRemove(Long[] dictCodes){
		return upmsDictDataDao.batchRemove(dictCodes);
	}
	
}
