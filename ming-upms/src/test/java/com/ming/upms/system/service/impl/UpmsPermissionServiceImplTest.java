package com.ming.upms.system.service.impl;

import com.ming.upms.common.BasicTest;
import com.ming.upms.system.domain.UpmsPermissionDO;
import com.ming.upms.system.service.UpmsPermissionService;
import javafx.scene.effect.SepiaTone;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;

public class UpmsPermissionServiceImplTest extends BasicTest {

    @Autowired
    private UpmsPermissionService upmsPermissionService;

    @Test
    public void get() {
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

    @Test
    public void getByUserId() {
        Set<UpmsPermissionDO> permissionDOSet = upmsPermissionService.getByUserId(1);
        System.out.println(permissionDOSet);
        //Assert.assertEquals();
    }

    @Test
    public void getPermsByUserId() {
        Set<String> permissionDOSet = upmsPermissionService.getPermsByUserId(1);
        for (String permission: permissionDOSet) {
            System.out.println(permission);
        }
    }
}