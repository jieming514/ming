package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 参数配置明细表
 * 
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2020-12-20 23:44:19
 */
public class UpmsConfigDataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//参数主键
	private Long configId;
	//参数名称
	private String configName;
	//参数键名
	private String configKey;
	//参数键值
	private String configValue;
	//系统内置（Y是 N否）
	private String configType;
	//创建者
	private String createBy;
	//创建时间
	private Date createTime;
	//更新者
	private String updateBy;
	//更新时间
	private Date updateTime;
	//备注
	private String remark;

	/**
	 * 设置：参数主键
	 */
	public void setConfigId(Long configId) {
		this.configId = configId;
	}
	/**
	 * 获取：参数主键
	 */
	public Long getConfigId() {
		return configId;
	}
	/**
	 * 设置：参数名称
	 */
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	/**
	 * 获取：参数名称
	 */
	public String getConfigName() {
		return configName;
	}
	/**
	 * 设置：参数键名
	 */
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	/**
	 * 获取：参数键名
	 */
	public String getConfigKey() {
		return configKey;
	}
	/**
	 * 设置：参数键值
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	/**
	 * 获取：参数键值
	 */
	public String getConfigValue() {
		return configValue;
	}
	/**
	 * 设置：系统内置（Y是 N否）
	 */
	public void setConfigType(String configType) {
		this.configType = configType;
	}
	/**
	 * 获取：系统内置（Y是 N否）
	 */
	public String getConfigType() {
		return configType;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新者
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新者
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
