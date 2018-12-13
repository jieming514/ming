package com.ming;

import com.ming.system.dao.UserDao;
import com.ming.system.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class MingApplicationTests {

    @Autowired
    public UserDao userDao;

    @Test
    public void contextLoads() {
        UserDO user = new UserDO();
        user.setUserId(1L);
        user = userDao.get(user.getUserId());

        System.out.printf("user:" + user);
    }

    /**
     * UserDao.list()
     */
    @Test
    public void list() {
        Map map = new HashMap();
        map.put("userName","mingjie");
        List<UserDO> userList = userDao.list(map);


        System.out.println("list.size():" + userList.size());
        for (UserDO userDO: userList) {
            System.out.println("userMess:" + userDO.toString());
        }



    }



}
