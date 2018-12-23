package com.ming.common.service.impl;

import com.ming.common.dao.LogDao;
import com.ming.common.domain.LogDO;
import com.ming.common.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/23 19:13
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public LogDO get(Long id) {
        return logDao.get(id);
    }

    @Override
    public List<LogDO> list(Map<String, Object> params) {
        return logDao.list(params);
    }

    @Override
    public int save(LogDO logDO) {
        return logDao.save(logDO);
    }


}
