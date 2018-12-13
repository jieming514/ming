package com.ming.system.service;

import com.ming.system.domain.UserDO;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserDO get(Long userId);

    List<UserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserDO userDO);

    boolean exit(Map<String, Object> map);
}
