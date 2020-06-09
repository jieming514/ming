package com.ming.upms.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 权限
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 15:17:30
 */
@ApiModel(value = "权限", description = "权限实体类")
public class UpmsPermissionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号")
	private Long permissionId;

	@ApiModelProperty(value = "所属系统")
	private Integer systemId;

	@ApiModelProperty(value = "所属系统名称")
	private String systemName;

	@ApiModelProperty(value = "所属上级")
	private Long pid;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "类型(1:目录,2:菜单,3:按钮)")
	private Integer type;

	@ApiModelProperty(value = "权限值")
	private String permissionValue;

	@ApiModelProperty(value = "路径")
	private String uri;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "状态(0:禁止,1:正常)")
	private Integer status;

	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date ctime;

	@ApiModelProperty(value = "排序")
	private Long orders;

	@ApiModelProperty(value = "角色是否拥有角色")
	private Boolean checked;


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
	/**
	 * 角色是否拥有资源标识
	 * @return
	 */

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}



	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UpmsPermissionDO{");
		sb.append("permissionId=").append(permissionId);
		sb.append(", systemId=").append(systemId);
		sb.append(", systemName='").append(systemName).append('\'');
		sb.append(", pid=").append(pid);
		sb.append(", name='").append(name).append('\'');
		sb.append(", type=").append(type);
		sb.append(", permissionValue='").append(permissionValue).append('\'');
		sb.append(", uri='").append(uri).append('\'');
		sb.append(", icon='").append(icon).append('\'');
		sb.append(", status=").append(status);
		sb.append(", ctime=").append(ctime);
		sb.append(", orders=").append(orders);
		sb.append(", locked='").append(checked).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
