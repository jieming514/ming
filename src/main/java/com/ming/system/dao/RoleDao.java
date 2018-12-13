package com.ming.system.dao;

import com.ming.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

public interface RoleDao {

    List<String> listUserRole(Long id);

    RoleDO get(Long id);

    List<RoleDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RoleDO roleDO);

    boolean remove(Long id);

    int update(RoleDO roleDO);


}
