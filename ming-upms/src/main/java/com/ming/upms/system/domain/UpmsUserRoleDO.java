package com.ming.upms.system.domain;

import java.io.Serializable;



/**
 * 用户角色关联表
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-17 22:03:25
 */
public class UpmsUserRoleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long userRoleId;
	//用户编号
	private Long userId;
	//角色编号
	private Long roleId;

	/**
	 * 设置：编号
	 */
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 * 获取：编号
	 */
	public Long getUserRoleId() {
		return userRoleId;
	}
	/**
	 * 设置：用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户编号
	 */
	public Long getUserId() {
		return userId;
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
}
