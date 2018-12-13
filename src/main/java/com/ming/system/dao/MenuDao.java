package com.ming.system.dao;

import com.ming.system.domain.MenuDO;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public interface MenuDao {

    int save(MenuDO menuDO);

    boolean remove(Long menuId);

    int update(MenuDO menuDO);

    MenuDO get(Long menuId);

    List<MenuDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);


    /**
     * 获取用户权限列表
     * @param id   用户ID
     * @return   List
     */
    List<String> listUserPerms(Long id);


    List<MenuDO> getSysMenuList(Long id);

}
