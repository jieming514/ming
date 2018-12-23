package com.ming.common.dao;

import com.ming.common.domain.LogDO;

import java.util.List;
import java.util.Map;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/19 23:22
 */
public interface LogDao {
    //增
    int save(LogDO logDO);

    LogDO get(Long id);

    List<LogDO> list(Map<String, Object> map);



}
