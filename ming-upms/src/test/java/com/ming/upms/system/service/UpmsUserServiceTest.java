package com.ming.upms.system.service;

import com.ming.upms.common.BasicTest;
import com.ming.upms.system.domain.UpmsUserDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UpmsUserServiceTest extends BasicTest {
    @Autowired
    public UpmsUserService upmsUserService;


    @Test
    public void get() {
        UpmsUserDO upmsUserDO = upmsUserService.get(1L);
        System.out.println(upmsUserDO.toString());
        Assert.assertEquals(new Integer("1"), upmsUserDO.getUserId());
    }

    @Test
    public void list() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void remove() {
    }

}