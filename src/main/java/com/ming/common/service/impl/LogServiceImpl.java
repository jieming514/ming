package com.ming.common.service.impl;

import com.ming.common.dao.LogDao;
import com.ming.common.domain.LogDO;
import com.ming.common.domain.PageDO;
import com.ming.common.service.LogService;
import com.ming.common.util.Query;
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
    public int count(Map<String, Object> params) {
        return logDao.count(params);
    }

    @Override
    public List<LogDO> list(Map<String, Object> params) {
        return logDao.list(params);
    }

    @Override
    public int save(LogDO logDO) {
        return logDao.save(logDO);
    }

    @Override
    public PageDO<LogDO> queryList(Query query) {
        int total = logDao.count(query);
        List<LogDO> logs = logDao.list(query);
        PageDO<LogDO> page = new PageDO<>();
        page.setTotal(total);
        page.setRows(logs);
        return page;
    }


}
