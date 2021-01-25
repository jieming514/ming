package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsDictDataDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 字典数据表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2021-01-25 23:16:01
 */
@Mapper
public interface UpmsDictDataDao {

    UpmsDictDataDO get(Long dictCode);

    List<UpmsDictDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UpmsDictDataDO upmsDictData);

    int update(UpmsDictDataDO upmsDictData);

    int remove(Long dict_code);

    int batchRemove(Long[] dictCodes);
}
