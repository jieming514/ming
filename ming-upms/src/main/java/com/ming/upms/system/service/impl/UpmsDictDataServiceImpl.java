package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsDictDataDao;
import com.ming.upms.system.domain.UpmsDictDataDO;
import com.ming.upms.system.service.UpmsDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 字典数据表
 * @author jie_ming514
 */
@Service("upmsDictDataService")
public class UpmsDictDataServiceImpl implements UpmsDictDataService {
    @Autowired
    private UpmsDictDataDao upmsDictDataDao;

    @Override
    public UpmsDictDataDO get(Long dictCode) {
        return upmsDictDataDao.get(dictCode);
    }

    @Override
    public List<UpmsDictDataDO> list(Map<String, Object> map) {
        return upmsDictDataDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return upmsDictDataDao.count(map);
    }

    @Override
    public int save(UpmsDictDataDO upmsDictData) {
        return upmsDictDataDao.save(upmsDictData);
    }

    @Override
    public int update(UpmsDictDataDO upmsDictData) {
        return upmsDictDataDao.update(upmsDictData);
    }

    @Override
    public int remove(Long dictCode) {
        return upmsDictDataDao.remove(dictCode);
    }

    @Override
    public int batchRemove(Long[] dictCodes) {
        return upmsDictDataDao.batchRemove(dictCodes);
    }

    @Override
    public List<UpmsDictDataDO> getType(String type) {
        Map map = new HashMap(1);
        map.put("dictType", type);
        return list(map);
    }

}
