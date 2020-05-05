package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsSystemDO;

import java.util.List;
import java.util.Map;

/**
 * 系统
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-04 13:04:29
 */
public interface UpmsSystemService {
	
	UpmsSystemDO get(Long systemId);
	
	List<UpmsSystemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsSystemDO upmsSystem);
	
	int update(UpmsSystemDO upmsSystem);
	
	int remove(Long systemId);
	
	int batchRemove(Long[] systemIds);

	List<UpmsSystemDO> getAvalidList(Map<String, Object> map);
}
