package com.ming.system.dao;

import com.ming.system.domain.DeptDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.*;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/16 23:51
 * @Description:
 */
@RestController
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptDaoTest {
    @Autowired
    private DeptDao deptDao;

    @Test
    public void save() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
        Long id = 6L;
        DeptDO deptDO = deptDao.get(id);
        Assert.assertEquals("销售部",deptDO.getName());
    }

    @Test
    public void list() {



    }

    @Test
    public void count() {
    }
}