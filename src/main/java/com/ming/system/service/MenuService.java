package com.ming.system.service;

import com.ming.common.domain.Tree;
import com.ming.system.domain.MenuDO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MenuService {


    /**
     * 获取用户权限列表
     * @param id   用户ID
     * @return   List
     */
    Set<String> listUserPerms(Long id);

    /**
     *
     * 功能描述: 获取用户的菜单树
     *
     * @param: 用户ID
     * @return: 菜单树、
     * @auther: jie_ming514@163.com
     * @date: 2018/10/13 0:20
     */
    Tree<MenuDO> getSysMenuTree(Long id);

    List<Tree<MenuDO>> getlistSysMenuTree(Long id);

    List<MenuDO> list(Map<String, Object> map);

    MenuDO get(Long id);

    boolean remove(Long id);

    int save(MenuDO menuDO);

    int update(MenuDO menuDO);

    Tree<MenuDO> getTree();

    Tree<MenuDO> getTree(Long id);
}
