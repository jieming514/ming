package com.ming.upms.system.service;

import com.ming.upms.common.BasicTest;
import com.ming.upms.system.domain.UpmsPermissionDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class UpmsPermissionServiceTest extends BasicTest {

    @Autowired
    private UpmsPermissionService upmsPermissionService;

    @Test
    public void getPermsByUserId() {
        Set<String> permissionDOSet = upmsPermissionService.getPermsByUserId(1L);
        for (String permission: permissionDOSet) {
            System.out.println(permission);
        }
    }

    @Test
    public void getPermissionByUserId() {
        List<UpmsPermissionDO> permissionList = upmsPermissionService.selectPermissionByUserId(1L);
        if (permissionList != null && permissionList.size() > 0) {
            Assert.assertEquals(new Long(1L), permissionList.get(0).getPermissionId());
        }

    }

}