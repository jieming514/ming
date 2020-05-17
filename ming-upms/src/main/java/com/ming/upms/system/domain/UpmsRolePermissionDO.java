package com.ming.upms.system.domain;

import java.io.Serializable;



/**
 * 角色权限关联表
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-17 22:00:49
 */
public class UpmsRolePermissionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long rolePermissionId;
	//角色编号
	private Long roleId;
	//权限编号
	private Long permissionId;

	/**
	 * 设置：编号
	 */
	public void setRolePermissionId(Long rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}
	/**
	 * 获取：编号
	 */
	public Long getRolePermissionId() {
		return rolePermissionId;
	}
	/**
	 * 设置：角色编号
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色编号
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * 设置：权限编号
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
	/**
	 * 获取：权限编号
	 */
	public Long getPermissionId() {
		return permissionId;
	}
}
