package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsUserDO;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-01 15:23:25
 */
public interface UpmsUserService {
	
	UpmsUserDO get(Long userId);
	
	List<UpmsUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsUserDO upmsUser);
	
	int update(UpmsUserDO upmsUser);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);

	/**
	 * 通过用户名获取用户信息
	 * @param username
	 * @return
	 */
	UpmsUserDO getUserByusername(String username);

	UpmsUserDO selectUserByUserId(Long userId);

	int selectUserCountByRole(Map<String,Object> map);

	List<UpmsUserDO> selectUserByRole(Map<String,Object> map);
	/**
	 * 校验email是否唯一
	 * @return
	 */
	String checkEmailUnique(UpmsUserDO upmsUserDO);

	/**
	 * 校验手机号是否唯一
	 */
	String checkPhoneUnique(UpmsUserDO upmsUserDO);
}
