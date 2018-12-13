package com.ming.system.dao;

import com.ming.system.domain.DeptDO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/16 23:28
 * @Description:
 */
public interface DeptDao {

    int save(DeptDO deptDO);

    boolean remove(Long id);

    int update(DeptDO deptDO);

    DeptDO get(Long id);

    List<DeptDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);



}
