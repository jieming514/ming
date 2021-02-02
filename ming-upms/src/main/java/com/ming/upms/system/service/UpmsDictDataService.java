package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsDictDataDO;

import java.util.List;
import java.util.Map;

/**
 * 字典数据表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2021-01-25 23:16:01
 */
public interface UpmsDictDataService {

    UpmsDictDataDO get(Long dictCode);

    List<UpmsDictDataDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UpmsDictDataDO upmsDictData);

    int update(UpmsDictDataDO upmsDictData);

    int remove(Long dictCode);

    int batchRemove(Long[] dictCodes);

    /**
     * 通过Type获取明细
     * @param type
     * @return
     */
    List<UpmsDictDataDO> getType(String type);
}
