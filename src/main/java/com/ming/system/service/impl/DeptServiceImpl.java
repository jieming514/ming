package com.ming.system.service.impl;

import com.ming.common.domain.Tree;
import com.ming.common.util.BuildTree;
import com.ming.system.dao.DeptDao;
import com.ming.system.domain.DeptDO;
import com.ming.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/18 22:29
 * @Description: 部门业务层
 */
@Service("deptService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public DeptDO get(Long id) {
        return deptDao.get(id);
    }

    @Override
    public List<DeptDO> list(Map<String, Object> map) {
        return deptDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return deptDao.count(map);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int save(DeptDO deptDO) {
        return deptDao.save(deptDO);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int update(DeptDO deptDO) {
        return deptDao.update(deptDO);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public boolean remove(Long deptId) {
        return deptDao.remove(deptId);
    }

    @Override
    public Tree<DeptDO> getTree() {
        List<Tree<DeptDO>> trees = new ArrayList<>();
        List<DeptDO> deptDOList = deptDao.list(new HashMap<>());
        for (DeptDO deptDO : deptDOList) {
            Tree<DeptDO> tree = new Tree<>();
            tree.setId(deptDO.getDeptId().toString());
            tree.setText(deptDO.getName());
            tree.setParentId(deptDO.getParentId().toString());
            Map<String, Object> state = new HashMap<>();
            state.put("opened", true);
            tree.setState(state);
            trees.add(tree);
        }
        Tree<DeptDO> result = BuildTree.build(trees);
        return result;
    }


}
