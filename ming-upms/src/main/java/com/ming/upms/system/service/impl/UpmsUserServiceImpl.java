package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsUserDao;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class UpmsUserServiceImpl implements UpmsUserService {
	@Autowired
	private UpmsUserDao upmsUserDao;
	
	@Override
	public UpmsUserDO get(Long userId){
		return upmsUserDao.get(userId);
	}
	
	@Override
	public List<UpmsUserDO> list(Map<String, Object> map){
		return upmsUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsUserDao.count(map);
	}
	
	@Override
	public int save(UpmsUserDO upmsUser){
		return upmsUserDao.save(upmsUser);
	}
	
	@Override
	public int update(UpmsUserDO upmsUser){
		return upmsUserDao.update(upmsUser);
	}
	
	@Override
	public int remove(Long userId){
		return upmsUserDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return upmsUserDao.batchRemove(userIds);
	}

	@Override
	public UpmsUserDO getUserByusername(String username) {
		return upmsUserDao.getUserByusername(username);
	}

	@Override
	public UpmsUserDO selectUserByUserId(Long userId) {
		return upmsUserDao.selectUserByUserId(userId);
	}

	@Override
	public int selectUserCountByRole(Map<String, Object> map) {
		return upmsUserDao.selectUserCountByRole(map);
	}

	@Override
	public List<UpmsUserDO> selectUserByRole(Map<String, Object> map) {
		return upmsUserDao.selectUserByRole(map);
	}


}
