package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 组织
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 14:29:52
 */
public class UpmsOrganizationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Integer organizationId;
	//所属上级
	private Integer pid;
	//组织名称
	private String name;
	//组织描述
	private String description;
	//创建时间
	private Long ctime;

	/**
	 * 设置：编号
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * 获取：编号
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
	/**
	 * 设置：所属上级
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：所属上级
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：组织名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：组织名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：组织描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：组织描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}
	/**
	 * 获取：创建时间
	 */
	public Long getCtime() {
		return ctime;
	}
}
