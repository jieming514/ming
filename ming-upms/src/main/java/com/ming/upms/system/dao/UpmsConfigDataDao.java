package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsConfigDataDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 参数配置明细表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2020-12-20 23:44:19
 */
@Mapper
public interface UpmsConfigDataDao {

    UpmsConfigDataDO get(Long configId);

    List<UpmsConfigDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UpmsConfigDataDO upmsConfigData);

    int update(UpmsConfigDataDO upmsConfigData);

    int remove(Long config_id);

    int batchRemove(Long[] configIds);
}
