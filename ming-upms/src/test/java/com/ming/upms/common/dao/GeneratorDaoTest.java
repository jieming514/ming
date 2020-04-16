package com.ming.upms.common.dao;


import com.ming.upms.common.BasicTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class GeneratorDaoTest extends BasicTest {

    @Autowired
    private GeneratorDao generatorDao;

    @Test
    public void listTest() {
        List<Map<String, Object>> list = generatorDao.list();
        System.out.println(list);
    }
}
