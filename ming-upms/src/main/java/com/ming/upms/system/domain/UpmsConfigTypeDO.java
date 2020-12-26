package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 参数配置类型表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2020-12-20 23:39:54
 */
public class UpmsConfigTypeDO implements Serializable {
    private static final long serialVersionUID = 1L;

    // 参数类型主键
    private Long configTypeId;
    // 参数类型名称
    private String typeName;
    //状态（0正常 1停用）
    private String status;
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
     * 设置：参数类型主键
     */
    public void setConfigTypeId(Long configTypeId) {
        this.configTypeId = configTypeId;
    }

    /**
     * 获取：参数类型主键
     */
    public Long getConfigTypeId() {
        return configTypeId;
    }

    /**
     * 设置：参数类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取：参数类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置：状态（0正常 1停用）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：状态（0正常 1停用）
     */
    public String getStatus() {
        return status;
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
