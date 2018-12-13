package com.ming.system.service.impl;

import com.ming.common.domain.Tree;
import com.ming.system.dao.DeptDao;
import com.ming.system.domain.DeptDO;
import com.ming.system.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.*;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/18 22:46
 * @Description:
 */
@RestController
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceImplTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void getTree() {
        Tree<DeptDO> trees = deptService.getTree();
        System.out.println(trees);
    }
}