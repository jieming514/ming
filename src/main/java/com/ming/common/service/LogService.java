package com.ming.common.service;

import com.ming.common.domain.LogDO;

import java.util.List;
import java.util.Map;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/23 19:12
 */
public interface LogService {

    LogDO get(Long id);

    List<LogDO> list(Map<String, Object> params);

    int save(LogDO logDO);

}
