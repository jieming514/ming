package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsDictTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 字典类型表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2021-01-25 23:06:39
 */
public interface UpmsDictTypeService {

    UpmsDictTypeDO get(Long dictId);

    List<UpmsDictTypeDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UpmsDictTypeDO upmsDictType);

    int update(UpmsDictTypeDO upmsDictType);

    int remove(Long dictId);

    int batchRemove(Long[] dictIds);
}
