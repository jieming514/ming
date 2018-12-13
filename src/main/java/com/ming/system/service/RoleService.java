package com.ming.system.service;

import com.ming.system.domain.RoleDO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleService {

    public Set<String> listUserRole(Long id);

    List<RoleDO> list(Map<String, Object> map);

    RoleDO get(Long id);

    int save(RoleDO roleDO);

    boolean remove(Long id);

    int update(RoleDO roleDO);

}
