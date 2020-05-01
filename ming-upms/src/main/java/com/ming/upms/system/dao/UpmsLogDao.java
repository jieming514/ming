package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 13:31:45
 */
@Mapper
public interface UpmsLogDao {

	UpmsLogDO get(Long logId);
	
	List<UpmsLogDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsLogDO upmsLog);
	
	int update(UpmsLogDO upmsLog);
	
	int remove(Long logId);
	
	int batchRemove(Long[] logIds);
}
