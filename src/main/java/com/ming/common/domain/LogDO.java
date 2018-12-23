package com.ming.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/19 23:25
 */
public class LogDO implements Serializable {

    //用户id
    private Long id;
    private String userId;
    //用户名
    private String username;
    //用户操作
    private String operation;
    //响应时间
    private int time;
    //请求方法
    private String method;
    //请求参数
    private String params;
    //IP地址
    private String ip;
    //创建时间
    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LogDO{");
        sb.append("id=").append(id);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", operation='").append(operation).append('\'');
        sb.append(", time=").append(time);
        sb.append(", method='").append(method).append('\'');
        sb.append(", params='").append(params).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append('}');
        return sb.toString();
    }
}
