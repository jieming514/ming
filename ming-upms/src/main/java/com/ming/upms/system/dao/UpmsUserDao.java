package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-01 15:23:25
 */
@Mapper
public interface UpmsUserDao {

	UpmsUserDO get(Long userId);
	
	List<UpmsUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsUserDO upmsUser);
	
	int update(UpmsUserDO upmsUser);
	
	int remove(Long user_id);
	
	int batchRemove(Long[] userIds);

	UpmsUserDO getUserByusername(String username);

	UpmsUserDO selectUserByUserId(Long userId);

	int selectUserCountByRole(Map<String,Object> map);

	List<UpmsUserDO> selectUserByRole(Map<String,Object> map);


	/**
	 * 校验email是否唯一
	 * @return
	 */
	UpmsUserDO checkEmailUnique(String email);

	/**
	 * 校验手机号是否唯一
	 */
	UpmsUserDO checkPhoneUnique(String email);

}
