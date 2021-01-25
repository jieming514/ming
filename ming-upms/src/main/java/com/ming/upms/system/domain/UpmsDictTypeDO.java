package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 字典类型表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2021-01-25 23:06:39
 */
public class UpmsDictTypeDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //字典主键
    private Long dictId;
    //字典名称
    private String dictName;
    //字典类型
    private String dictType;
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
     * 设置：字典主键
     */
    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    /**
     * 获取：字典主键
     */
    public Long getDictId() {
        return dictId;
    }

    /**
     * 设置：字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取：字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 设置：字典类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取：字典类型
     */
    public String getDictType() {
        return dictType;
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
