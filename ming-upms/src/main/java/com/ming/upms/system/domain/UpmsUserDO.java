package com.ming.upms.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-01 15:23:25
 */
@ApiModel(value = "用户权限关系", description = "用户权限关系实体类")
public class UpmsUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "编号")
	private Long userId;
	@ApiModelProperty(value = "帐号")
	private String username;
	@ApiModelProperty(value = "密码MD5(密码+盐)")
	private String password;
	@ApiModelProperty(value = "盐")
	private String salt;
	@ApiModelProperty(value = "姓名")
	private String realname;
	@ApiModelProperty(value = "头像")
	private String avatar;
	@ApiModelProperty(value = "电话")
	private String phone;
	@ApiModelProperty(value = "邮箱")
	private String email;
	@ApiModelProperty(value = "性别")
	private Integer sex;
	@ApiModelProperty(value = "状态(0:正常,1:锁定)")
	private Integer locked;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date ctime;

	@ApiModelProperty(value = "组织ID")
	private Long organizationId;

	@ApiModelProperty(value = "组织信息")
	private UpmsOrganizationDO upmsOrganizationDO;

	/**
	 * 设置：编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：编号
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：帐号
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：帐号
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码MD5(密码+盐)
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码MD5(密码+盐)
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：姓名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：状态(0:正常,1:锁定)
	 */
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	/**
	 * 获取：状态(0:正常,1:锁定)
	 */
	public Integer getLocked() {
		return locked;
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

	public UpmsOrganizationDO getUpmsOrganizationDO() {
		return upmsOrganizationDO;
	}

	public void setUpmsOrganizationDO(UpmsOrganizationDO upmsOrganizationDO) {
		this.upmsOrganizationDO = upmsOrganizationDO;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UpmsUserDO{");
		sb.append("userId=").append(userId);
		sb.append(", username='").append(username).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", salt='").append(salt).append('\'');
		sb.append(", realname='").append(realname).append('\'');
		sb.append(", avatar='").append(avatar).append('\'');
		sb.append(", phone='").append(phone).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", sex=").append(sex);
		sb.append(", locked=").append(locked);
		sb.append(", ctime=").append(ctime);
		sb.append(", organizationId=").append(organizationId);
		sb.append(", upmsOrganizationDO=").append(upmsOrganizationDO);
		sb.append('}');
		return sb.toString();
	}
}
