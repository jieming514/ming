package com.ming.upms.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Long organizationId;
	//组织名称
	private String name;
	//所属上级
	private Long pid;
	//上级名称
	private String pName;

	//组织描述
	private String description;
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date ctime;

	/**
	 * 设置：编号
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * 获取：编号
	 */
	public Long getOrganizationId() {
		return organizationId;
	}
	/**
	 * 设置：所属上级
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：所属上级
	 */
	public Long getPid() {
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

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
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
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCtime() {
		return ctime;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UpmsOrganizationDO{");
		sb.append("organizationId=").append(organizationId);
		sb.append(", pid=").append(pid);
		sb.append(", name='").append(name).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", ctime=").append(ctime);
		sb.append('}');
		return sb.toString();
	}
}
