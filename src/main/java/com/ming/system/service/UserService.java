package com.ming.system.service;

import com.ming.system.domain.UserDO;
import com.ming.system.domain.UserVO;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserDO get(Long userId);

    List<UserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserDO userDO);

    boolean exit(Map<String, Object> map);

    int update(UserDO userDO);

    int remove(Long id) throws Exception;

    /**
     * 功能描述: 重置密码
     *
     * @param: userDO
     *            userId  用户ID
     *            pwd     密码
     * @return: 更新条数
     * @auther: jie_ming514@163.com
     * @date: 2018/12/17 22:35
     */
    int adminResetPwd(UserVO userVO) throws Exception;
}
