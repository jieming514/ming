package com.ming.system.service.impl;

import com.ming.system.dao.RoleDao;
import com.ming.system.dao.RoleMenuDao;
import com.ming.system.domain.RoleDO;
import com.ming.system.domain.RoleMenuDO;
import com.ming.system.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("roleService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public Set<String> listUserRole(Long id) {
        List<String> roleList = roleDao.listUserRole(id);
        Set<String> roleSet = new HashSet<>();
        for (String role: roleList) {
            if (StringUtils.isNotEmpty(role)) {
                roleSet.addAll(Arrays.asList(role.split(",")));
            }
        }
        return roleSet;
    }

    @Override
    public List<RoleDO> list(Map<String, Object> map) {
        return roleDao.list(map);
    }

    @Override
    public RoleDO get(Long id) {
        return roleDao.get(id);
    }


    /**
     *
     * 功能描述: 保存角色信息
     *
     * @param: 新增角色信息
     * @return: 新增条数
     * @auther: jie_ming514@163.com
     * @date: 2018/10/13 16:34
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int save(RoleDO roleDO) {
        //1.像sys_role表中添加信息
        int count = roleDao.save(roleDO);
        //2. 获取菜单信息
        List<Long> menus = roleDO.getMenuIds();
        Long roleId = roleDO.getRoleId();
        //3. 删除该角色下所有的菜单
        roleMenuDao.removeByRoleId(roleId);
        //4.新增变更后的菜单
        List<RoleMenuDO> rms = new ArrayList<>();
        for (Long menu : menus) {
            RoleMenuDO roleMenuDO = new RoleMenuDO();
            roleMenuDO.setRoleId(roleId);
            roleMenuDO.setMenuId(menu);
            rms.add(roleMenuDO);
        }
        if (rms.size() > 0) {
            roleMenuDao.batchsave(rms);
        }
        return count;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public boolean remove(Long id) {
        roleMenuDao.removeByRoleId(id);
        boolean hasRemove = roleDao.remove(id);
        return hasRemove;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int update(RoleDO roleDO) {
        int count = roleDao.update(roleDO);
        //2. 获取菜单信息
        List<Long> menus = roleDO.getMenuIds();
        Long roleId = roleDO.getRoleId();
        //3. 删除该角色下所有的菜单
        roleMenuDao.removeByRoleId(roleId);
        //4.新增变更后的菜单
        List<RoleMenuDO> rms = new ArrayList<>();
        for (Long menu : menus) {
            RoleMenuDO roleMenuDO = new RoleMenuDO();
            roleMenuDO.setRoleId(roleId);
            roleMenuDO.setMenuId(menu);
            rms.add(roleMenuDO);
        }
        if (rms.size() > 0) {
            roleMenuDao.batchsave(rms);
        }
        return count;
    }

}
