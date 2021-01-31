package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsDictTypeDao;
import com.ming.upms.system.domain.UpmsDictTypeDO;
import com.ming.upms.system.service.UpmsDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UpmsDictTypeServiceImpl implements UpmsDictTypeService {
    @Autowired
    private UpmsDictTypeDao upmsDictTypeDao;

    @Override
    public UpmsDictTypeDO get(Long dictId) {
        return upmsDictTypeDao.get(dictId);
    }

    @Override
    public List<UpmsDictTypeDO> list(Map<String, Object> map) {
        return upmsDictTypeDao.list(map);
    }

    @Override
    public List<UpmsDictTypeDO> listAll() {
        return list(null);
    }

    @Override
    public int count(Map<String, Object> map) {
        return upmsDictTypeDao.count(map);
    }

    @Override
    public int save(UpmsDictTypeDO upmsDictType) {
        return upmsDictTypeDao.save(upmsDictType);
    }

    @Override
    public int update(UpmsDictTypeDO upmsDictType) {
        return upmsDictTypeDao.update(upmsDictType);
    }

    @Override
    public int remove(Long dictId) {
        return upmsDictTypeDao.remove(dictId);
    }

    @Override
    public int batchRemove(Long[] dictIds) {
        return upmsDictTypeDao.batchRemove(dictIds);
    }

}
