package com.ming.upms.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;



/**
 * 角色权限关联表
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-17 22:00:49
 */
@ApiModel(value = "角色权限关系", description = "角色权限关系实体类")
public class UpmsRolePermissionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "编号")
	private Long rolePermissionId;
	@ApiModelProperty(value = "角色编号")
	private Long roleId;
	@ApiModelProperty(value = "权限编号")
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
