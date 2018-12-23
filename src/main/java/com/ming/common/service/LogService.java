package com.ming.common.service;

import com.ming.common.domain.LogDO;
import com.ming.common.domain.PageDO;
import com.ming.common.util.Query;

import java.util.List;
import java.util.Map;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/23 19:12
 */
public interface LogService {

    LogDO get(Long id);

    int count(Map<String, Object> params);

    List<LogDO> list(Map<String, Object> params);

    int save(LogDO logDO);

    PageDO<LogDO> queryList(Query query);
}
