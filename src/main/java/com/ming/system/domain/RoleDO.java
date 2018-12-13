package com.ming.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RoleDO implements Serializable {

    private Long roleId;
    private String roleName;
    private String roleSign;
    private String remark;
    private String userIdCreate;
    private Date gmtCreate;
    private Date gmtModified;
    private List<Long> menuIds;

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RoleDO{");
        sb.append("roleId=").append(roleId);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", roleSign='").append(roleSign).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", userIdCreate='").append(userIdCreate).append('\'');
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", menuIds=").append(menuIds);
        sb.append('}');
        return sb.toString();
    }
}
