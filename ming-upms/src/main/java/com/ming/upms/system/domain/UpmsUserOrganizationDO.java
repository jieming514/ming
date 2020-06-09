package com.ming.upms.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;



/**
 * 用户组织关联表
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-10 14:20:51
 */
@ApiModel(value = "用户组织关系", description = "用户组织关系实体类")
public class UpmsUserOrganizationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "编号")
	private Integer userOrganizationId;
	@ApiModelProperty(value = "用户编号")
	private Integer userId;
	@ApiModelProperty(value = "组织编号")
	private Integer organizationId;

	/**
	 * 设置：编号
	 */
	public void setUserOrganizationId(Integer userOrganizationId) {
		this.userOrganizationId = userOrganizationId;
	}
	/**
	 * 获取：编号
	 */
	public Integer getUserOrganizationId() {
		return userOrganizationId;
	}
	/**
	 * 设置：用户编号
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户编号
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：组织编号
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * 获取：组织编号
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
}
