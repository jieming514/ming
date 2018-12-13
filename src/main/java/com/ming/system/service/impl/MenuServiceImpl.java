package com.ming.system.service.impl;

import com.ming.common.domain.Tree;
import com.ming.common.util.BuildTree;
import com.ming.system.dao.MenuDao;
import com.ming.system.dao.RoleMenuDao;
import com.ming.system.domain.MenuDO;
import com.ming.system.service.MenuService;
import com.sun.tools.doclint.Entity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("menuService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleMenuDao roleMenuDao;


    /**
     * 获取用户的权限
     * @param id   用户ID
     * @return
     */
    @Override
    public Set<String> listUserPerms(Long id) {
        List<String> userPerms = menuDao.listUserPerms(id);
        Set<String> permSet = new HashSet<>();
        for (String perm: userPerms) {
            if(StringUtils.isNotEmpty(perm)) {
                permSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permSet;
    }


    /**
     * 获取系统树
     * @param id
     * @return
     */
    @Override
    public Tree<MenuDO> getSysMenuTree(Long id) {
        List<Tree<MenuDO>> trees = new ArrayList<>();

        List<MenuDO> menuDOList = menuDao.getSysMenuList(id);
        for (MenuDO menuDO : menuDOList) {
            Tree<MenuDO> tree = new Tree<>();
            tree.setId(menuDO.getMenuId().toString());
            tree.setText(menuDO.getName());
            tree.setParentId(menuDO.getParentId().toString());
            Map<String, Object> attributes = new HashMap<>();
            //attributes.put("url", menuDO.getUrl());
            attributes.put("icon", menuDO.getIcon());
            tree.setAttributes(attributes);
            trees.add(tree);
        }

        Tree<MenuDO> resultTree = BuildTree.build(trees);
        return resultTree;
    }


    /**
     * 获取系统列表
     * @param id
     * @return
     */
    @Override
    public List<Tree<MenuDO>> getlistSysMenuTree(Long id) {
        List<Tree<MenuDO>> trees = new ArrayList<>();

        List<MenuDO> menuDOList = menuDao.getSysMenuList(id);
        for (MenuDO menuDO : menuDOList) {
            Tree<MenuDO> tree = new Tree<>();
            tree.setId(menuDO.getMenuId().toString());
            tree.setText(menuDO.getName());
            tree.setParentId(menuDO.getParentId().toString());
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("url",menuDO.getUrl());
            attributes.put("icon",menuDO.getIcon());
            tree.setAttributes(attributes);
            trees.add(tree);
        }
        List<Tree<MenuDO>> resultListTrees = BuildTree.buildList(trees,"0");
        return resultListTrees;
    }


    @Override
    public List<MenuDO> list(Map<String, Object> map) {
        return menuDao.list(map);
    }

    /**
     *
     * 功能描述: 获取一个菜单信息
     *
     * @param:
     * @return:
     * @auther: jie_ming514@163.com
     * @date: 2018/10/12 23:27
     */
    @Override
    public MenuDO get(Long id) {
        return menuDao.get(id);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public boolean remove(Long id) {
        return menuDao.remove(id);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int save(MenuDO menuDO) {
        return menuDao.save(menuDO);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int update(MenuDO menuDO) {
        return menuDao.update(menuDO);
    }

    @Override
    public Tree<MenuDO> getTree() {
        List<Tree<MenuDO>> trees = new ArrayList<>();
        List<MenuDO> menuDOList = menuDao.list(new HashMap<>());
        for (MenuDO menuDO : menuDOList) {
            Tree<MenuDO> tree = new Tree<MenuDO>();
            tree.setId(menuDO.getMenuId().toString());
            tree.setParentId(menuDO.getParentId().toString());
            tree.setText(menuDO.getName());
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<MenuDO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public Tree<MenuDO> getTree(Long id) {
        // 根据roleId查询权限
        List<MenuDO> menus = menuDao.list(new HashMap<String, Object>(16));
        List<Long> menuIds = roleMenuDao.listMenuIdByRoleId(id);
        List<Long> temp = menuIds;
        for (MenuDO menu : menus) {
            if (temp.contains(menu.getParentId())) {
                menuIds.remove(menu.getParentId());
            }
        }
        List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
        List<MenuDO> menuDOs = menuDao.list(new HashMap<String, Object>(16));
        for (MenuDO sysMenuDO : menuDOs) {
            Tree<MenuDO> tree = new Tree<MenuDO>();
            tree.setId(sysMenuDO.getMenuId().toString());
            tree.setParentId(sysMenuDO.getParentId().toString());
            tree.setText(sysMenuDO.getName());
            Map<String, Object> state = new HashMap<>(16);
            Long menuId = sysMenuDO.getMenuId();
            if (menuIds.contains(menuId)) {
                state.put("selected", true);
            } else {
                state.put("selected", false);
            }
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<MenuDO> t = BuildTree.build(trees);
        return t;
    }




}
