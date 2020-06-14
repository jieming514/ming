package com.ming.upms.system.service;

import com.ming.upms.common.BasicTest;
import com.ming.upms.system.domain.UpmsRoleDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UpmsRoleServiceTest extends BasicTest {

    @Autowired
    private UpmsRoleService upmsRoleService;

    @Test
    public void get() {
        UpmsRoleDO upmsUserDO = upmsRoleService.get(1L);
        System.out.println(upmsUserDO);
        Assert.assertEquals(new Long(1L), upmsUserDO.getRoleId());
    }

}