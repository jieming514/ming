package com.ming.system.service.impl;

import com.ming.system.domain.RoleDO;
import com.ming.system.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        map.put("roleSign","admin");
        List<RoleDO> list = roleService.list(map);

        for (RoleDO roleDO : list) {
            System.out.println(roleDO.toString());
        }

    }
}