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
        Assert.assertEquals(new Long(1L), upmsUserDO.getUserId());
    }

    @Test
    public void selectUserByUserId() {
        UpmsUserDO upmsUserDO = upmsUserService.selectUserByUserId(1L);
        Assert.assertEquals(new Long(1L), upmsUserDO.getUserId());
        Assert.assertEquals("admin", upmsUserDO.getUsername());
    }

}