package com.ming.system.service;

import com.ming.common.domain.Tree;
import com.ming.system.domain.DeptDO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/18 22:27
 * @Description: 部门类
 */
public interface DeptService {

    DeptDO get(Long id);

    List<DeptDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(DeptDO deptDO);

    int update(DeptDO deptDO);

    boolean remove(Long deptId);

    /**
     * 功能描述: 获取部门结构树
     *
     * @param: null
     * @return: 部门结构树
     * @auther: jie_ming514@163.com
     * @date: 2018/10/18 22:32
     */
    Tree<DeptDO> getTree();

}
