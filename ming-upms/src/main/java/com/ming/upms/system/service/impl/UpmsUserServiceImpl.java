package com.ming.upms.system.service.impl;

import com.ming.upms.system.dao.UpmsUserDao;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("upmsUserServiceImpl")
public class UpmsUserServiceImpl implements UpmsUserService {

    @Autowired
    private UpmsUserDao upmsUserDao;

    @Override
    public UpmsUserDO get(Long userId) {
        return upmsUserDao.get(userId);
    }

    @Override
    public List<UpmsUserDO> list(Map<String, Object> params) {
        return upmsUserDao.list(params);
    }

    @Override
    public int insert(UpmsUserDO upmsUserDO) {
        return 0;
    }

    @Override
    public int update(UpmsUserDO upmsUserDO) {
        return 0;
    }

    @Override
    public int remove(Long userId) {
        return 0;
    }

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    @Override
    public UpmsUserDO getUserByName(String userName) {
        return upmsUserDao.getUserByName(userName);
    }

}
