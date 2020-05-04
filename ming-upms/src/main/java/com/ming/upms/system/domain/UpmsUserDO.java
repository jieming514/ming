package com.ming.upms.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-05-01 15:23:25
 */
public class UpmsUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long userId;
	//帐号
	private String username;
	//密码MD5(密码+盐)
	private String password;
	//盐
	private String salt;
	//姓名
	private String realname;
	//头像
	private String avatar;
	//电话
	private String phone;
	//邮箱
	private String email;
	//性别
	private Integer sex;
	//状态(0:正常,1:锁定)
	private Integer locked;
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date ctime;

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
}
