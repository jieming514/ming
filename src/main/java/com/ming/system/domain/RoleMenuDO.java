package com.ming.system.domain;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/13 16:00
 * @Description: 角色菜单映射表
 */
public class RoleMenuDO {

    private Long id;

    private Long roleId;

    private Long menuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RoleMenuDO{");
        sb.append("id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", menuId=").append(menuId);
        sb.append('}');
        return sb.toString();
    }
}
