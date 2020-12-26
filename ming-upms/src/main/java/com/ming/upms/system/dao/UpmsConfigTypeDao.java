package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsConfigTypeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 参数配置类型表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2020-12-20 23:39:54
 */
@Mapper
public interface UpmsConfigTypeDao {

    UpmsConfigTypeDO get(Long configTypeId);

    List<UpmsConfigTypeDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UpmsConfigTypeDO upmsConfigType);

    int update(UpmsConfigTypeDO upmsConfigType);

    int remove(Long config_type_id);

    int batchRemove(Long[] configTypeIds);
}
