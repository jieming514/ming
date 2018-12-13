package com.ming.system.service.impl;

import com.ming.system.dao.UserDao;
import com.ming.system.domain.UserDO;
import com.ming.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDO get(Long userId) {
        return userDao.get(userId);
    }


    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int save(UserDO userDO) {
        return userDao.save(userDO);
    }

    /**
     * 功能描述: 查看用户是否存在
     *
     * @param: 
     * @return: 
     * @auther: jie_ming514@163.com
     * @date: 2018/11/4 23:45
     */
    @Override
    public boolean exit(Map<String, Object> map) {
        return userDao.list(map).size() > 0;
    }

}
