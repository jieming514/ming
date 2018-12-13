package com.ming.system.service.impl;

import com.ming.system.domain.UserDO;
import com.ming.system.service.UserService;
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
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void list() {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", 0);
        map.put("limit", 10);
        List<UserDO> list = userService.list(map);

        for (UserDO userDO : list) {
            System.out.println(userDO.toString());
        }


    }
}