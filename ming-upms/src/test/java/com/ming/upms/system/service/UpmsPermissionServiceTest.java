package com.ming.upms.system.service;

import com.ming.upms.common.BasicTest;
import com.ming.upms.system.domain.UpmsPermissionDO;
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
        List<UpmsPermissionDO> permissionSet = upmsPermissionService.getPermissionByUserId(1L);
        System.out.printf(permissionSet.toString());
    }

}