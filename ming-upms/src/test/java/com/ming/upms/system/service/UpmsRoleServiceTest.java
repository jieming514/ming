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
        Assert.assertEquals(new Integer("1"), upmsUserDO.getRoleId());
    }

    @Test
    public void list() {
    }

    @Test
    public void count() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void batchRemove() {
    }
}