package com.ming.system.dao;

import com.ming.system.domain.RoleMenuDO;

import javax.management.relation.Role;
import java.util.List;
import java.util.Map;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/13 16:02
 * @Description:
 */
public interface RoleMenuDao {

    List<RoleMenuDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    RoleMenuDO get(Long id);

    int save(RoleMenuDO roleMenuDO);

    int remove(Long id);

    int batchRemove(Long[] ids);

    int update(RoleMenuDO roleMenuDO);

    /**
     * 功能描述: 获取角色下的所有菜单
     *
     * @param: 角色ID
     * @return: 菜单IDS
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:04
     */
    List<Long> listMenuIdByRoleId(Long id);

    /**
     * 功能描述: 通过角色ID删除角色与菜单的关联
     *
     * @param: 角色ID
     * @return: 删除条数
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:09
     */
    int removeByRoleId(Long roleId);

    /**
     * 功能描述: 通过菜单ID删除角色与菜单的关联关系
     *
     * @param: 菜单ID
     * @return: 删除条数
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:11
     */
    int removeByMenuId(Long menuId);

    /**
     * 功能描述: 批量新增角色与菜单的关联关系
     *
     * @param: 角色与菜单的关联关系列表
     * @return: 新增条数
     * @auther: jie_ming514@163.com
     * @date: 2018/10/14 0:17
     */
    int batchsave(List<RoleMenuDO> rms);
}
