package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsUserDO;

import java.util.List;
import java.util.Map;

public interface UpmsUserService {

    UpmsUserDO get(Long userId);

    List<UpmsUserDO> list(Map<String, Object> params);

    int insert(UpmsUserDO upmsUserDO);

    int update(UpmsUserDO upmsUserDO);

    int remove(Long userId);

    public UpmsUserDO getUserByName(String userName);
}
