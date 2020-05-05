package com.ming.upms.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 权限
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 15:17:30
 */
public class UpmsPermissionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long permissionId;
	//所属系统
	private Integer systemId;
	//所属系统名称
	private String systemName;
	//所属上级
	private Integer pid;
	//名称
	private String name;
	//类型(1:目录,2:菜单,3:按钮)
	private Integer type;
	//权限值
	private String permissionValue;
	//路径
	private String uri;
	//图标
	private String icon;
	//状态(0:禁止,1:正常)
	private Integer status;
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date ctime;
	//排序
	private Long orders;

	/**
	 * 设置：编号
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
	/**
	 * 获取：编号
	 */
	public Long getPermissionId() {
		return permissionId;
	}
	/**
	 * 设置：所属系统
	 */
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	/**
	 * 获取：所属系统
	 */
	public Integer getSystemId() {
		return systemId;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：类型(1:目录,2:菜单,3:按钮)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型(1:目录,2:菜单,3:按钮)
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：权限值
	 */
	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}
	/**
	 * 获取：权限值
	 */
	public String getPermissionValue() {
		return permissionValue;
	}
	/**
	 * 设置：路径
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * 获取：路径
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * 设置：图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：状态(0:禁止,1:正常)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(0:禁止,1:正常)
	 */
	public Integer getStatus() {
		return status;
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
	/**
	 * 设置：排序
	 */
	public void setOrders(Long orders) {
		this.orders = orders;
	}
	/**
	 * 获取：排序
	 */
	public Long getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UpmsPermissionDO{");
		sb.append("permissionId=").append(permissionId);
		sb.append(", systemId=").append(systemId);
		sb.append(", pid=").append(pid);
		sb.append(", name='").append(name).append('\'');
		sb.append(", type=").append(type);
		sb.append(", permissionValue='").append(permissionValue).append('\'');
		sb.append(", uri='").append(uri).append('\'');
		sb.append(", icon='").append(icon).append('\'');
		sb.append(", status=").append(status);
		sb.append(", ctime=").append(ctime);
		sb.append(", orders=").append(orders);
		sb.append('}');
		return sb.toString();
	}
}
