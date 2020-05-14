package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 13:31:45
 */
public class UpmsLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Integer logId;
	//操作描述
	private String description;
	//操作用户
	private String username;
	//操作时间
	private Date startTime;
	//消耗时间
	private Integer spendTime;
	//根路径
	private String basePath;
	//URI
	private String uri;
	//URL
	private String url;
	//请求类型
	private String method;
	//
	private String parameter;
	//用户标识
	private String userAgent;
	//IP地址
	private String ip;
	//
	private String result;
	//权限值
	private String permissions;

	/**
	 * 设置：编号
	 */
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	/**
	 * 获取：编号
	 */
	public Integer getLogId() {
		return logId;
	}
	/**
	 * 设置：操作描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：操作描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：操作用户
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：操作用户
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：操作时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：消耗时间
	 */
	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}
	/**
	 * 获取：消耗时间
	 */
	public Integer getSpendTime() {
		return spendTime;
	}
	/**
	 * 设置：根路径
	 */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	/**
	 * 获取：根路径
	 */
	public String getBasePath() {
		return basePath;
	}
	/**
	 * 设置：URI
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	/**
	 * 获取：URI
	 */
	public String getUri() {
		return uri;
	}
	/**
	 * 设置：URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：URL
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：请求类型
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：请求类型
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	/**
	 * 获取：
	 */
	public String getParameter() {
		return parameter;
	}
	/**
	 * 设置：用户标识
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	/**
	 * 获取：用户标识
	 */
	public String getUserAgent() {
		return userAgent;
	}
	/**
	 * 设置：IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：IP地址
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 获取：
	 */
	public String getResult() {
		return result;
	}
	/**
	 * 设置：权限值
	 */
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	/**
	 * 获取：权限值
	 */
	public String getPermissions() {
		return permissions;
	}
}
