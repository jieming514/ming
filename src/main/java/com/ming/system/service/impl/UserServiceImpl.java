package com.ming.system.service.impl;

import com.ming.common.util.MD5Utils;
import com.ming.system.dao.UserDao;
import com.ming.system.domain.UserDO;
import com.ming.system.domain.UserVO;
import com.ming.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

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

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int update(UserDO userDO) {
        return userDao.update(userDO);
    }


    /**
     * 功能描述: 删除用户
     *
     * @param: 用户ID
     * @return: 删除条数
     * @auther: jie_ming514@163.com
     * @date: 2018/12/17 23:23
     */
    @Override
    public int remove(Long id) throws Exception {
        UserDO userDO = get(id);
        if ("admin".equals(userDO.getUserName())) {
            throw new Exception("管理员无法直接删除！");
        }


        return 0;
    }

    /**
     * 功能描述: admin 直接更改用户密码
     *
     * @param: 用户密码和新密码
     * @return: 更新数据条数
     * @auther: jie_ming514@163.com
     * @date: 2018/12/17 22:53
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int adminResetPwd(UserVO userVO) throws Exception {
        UserDO userDO = get(userVO.getUserDO().getUserId());
        if("admin".equals(userDO.getUserName())) {
            throw new Exception("管理员密码不能直接修改");
        }
        //加密
        userDO.setPassword(MD5Utils.encrypt(userDO.getUserName(), userVO.getPwdNew()));
        logger.debug(userDO.toString());
        return userDao.update(userDO);
    }

}
