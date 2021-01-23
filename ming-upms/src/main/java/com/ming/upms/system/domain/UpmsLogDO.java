package com.ming.upms.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志
 *
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-06 13:31:45
 */
@ColumnWidth(15)
@ApiModel(value = "日志", description = "用户操作日志")
public class UpmsLogDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "编号",index = 0)
    @ApiModelProperty(value = "编号ID")
    private Integer logId;

    @ExcelProperty(value = "操作描述",index = 1)
    @ApiModelProperty(value = "操作描述")
    private String description;

    @ExcelProperty(value = "操作用户",index = 2)
    @ApiModelProperty(value = "操作用户")
    private String username;

    @ExcelProperty(value = "操作开始时间",index = 3)
    @ApiModelProperty(value = "操作开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @ExcelProperty(value = "消耗时间(ms)",index = 4)
    @ApiModelProperty(value = "消耗时间")
    private Integer spendTime;

    @ExcelProperty(value = "根路径",index = 5)
    @ApiModelProperty(value = "根路径")
    private String basePath;

    @ExcelProperty(value = "URI",index = 6)
    @ApiModelProperty(value = "URI")
    private String uri;

    @ExcelProperty(value = "请求类型",index = 7)
    @ApiModelProperty(value = "请求类型")
    private String method;

    @ExcelProperty(value = "请求参数",index = 8)
    @ApiModelProperty(value = "请求参数")
    private String parameter;

    @ExcelProperty(value = "用户标识",index = 9)
    @ApiModelProperty(value = "用户标识")
    private String userAgent;

    @ExcelProperty(value = "IP地址",index = 10)
    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ExcelProperty(value = "请求结果",index = 11)
    @ApiModelProperty(value = "请求结果")
    private Integer result;

    @ExcelIgnore
    @ApiModelProperty(value = "权限值")
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
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 获取：
     */
    public Integer getResult() {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UpmsLogDO{");
        sb.append("logId=").append(logId);
        sb.append(", description='").append(description).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", spendTime=").append(spendTime);
        sb.append(", basePath='").append(basePath).append('\'');
        sb.append(", uri='").append(uri).append('\'');
        sb.append(", method='").append(method).append('\'');
        sb.append(", parameter='").append(parameter).append('\'');
        sb.append(", userAgent='").append(userAgent).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", result=").append(result);
        sb.append(", permissions='").append(permissions).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
