package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsLogDO;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 13:31:45
 */
public interface UpmsLogService {
	
	UpmsLogDO get(Integer logId);
	
	List<UpmsLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsLogDO upmsLog);
	
	int update(UpmsLogDO upmsLog);
	
	int remove(Integer logId);
	
	int batchRemove(Integer[] logIds);
}
