package com.ming.system.service.impl;

import com.ming.common.domain.Tree;
import com.ming.system.domain.MenuDO;
import com.ming.system.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.*;

@RestController()
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceImplTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void getSysMenuTree() {
        Long id = Long.valueOf(1);
        Tree<MenuDO> menuDOTree =  menuService.getSysMenuTree(id);
        System.out.println(menuDOTree.toString());
    }
}