package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsConfigDataDO;

import java.util.List;
import java.util.Map;

/**
 * 参数配置明细表
 * 
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2020-12-20 23:44:19
 */
public interface UpmsConfigDataService {
	
	UpmsConfigDataDO get(Long configId);
	
	List<UpmsConfigDataDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsConfigDataDO upmsConfigData);
	
	int update(UpmsConfigDataDO upmsConfigData);
	
	int remove(Long configId);
	
	int batchRemove(Long[] configIds);
}
