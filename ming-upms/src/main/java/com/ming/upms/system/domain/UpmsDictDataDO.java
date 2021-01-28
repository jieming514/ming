package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 字典数据表
 *
 * @author jie_ming514
 * @email jie_ming514@163.com
 * @date 2021-01-25 23:16:01
 */
public class UpmsDictDataDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //字典编码
    private Long dictCode;
    //字典排序
    private Integer dictSort;
    //字典标签
    private String dictLabel;
    //字典键值
    private String dictValue;
    //字典类型
    private String dictType;
    //样式属性（其他样式扩展）
    private String cssClass;
    //表格回显样式
    private String listClass;
    //是否默认（Y是 N否）
    private String isDefault;
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
     * 设置：字典编码
     */
    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    /**
     * 获取：字典编码
     */
    public Long getDictCode() {
        return dictCode;
    }

    /**
     * 设置：字典排序
     */
    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    /**
     * 获取：字典排序
     */
    public Integer getDictSort() {
        return dictSort;
    }

    /**
     * 设置：字典标签
     */
    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    /**
     * 获取：字典标签
     */
    public String getDictLabel() {
        return dictLabel;
    }

    /**
     * 设置：字典键值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 获取：字典键值
     */
    public String getDictValue() {
        return dictValue;
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
     * 设置：样式属性（其他样式扩展）
     */
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * 获取：样式属性（其他样式扩展）
     */
    public String getCssClass() {
        return cssClass;
    }

    /**
     * 设置：表格回显样式
     */
    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    /**
     * 获取：表格回显样式
     */
    public String getListClass() {
        return listClass;
    }

    /**
     * 设置：是否默认（Y是 N否）
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取：是否默认（Y是 N否）
     */
    public String getIsDefault() {
        return isDefault;
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

    /**
     * 添加创建人
     * @return
     */
    public void addCreator(String creator) {
        this.createBy = creator;
        this.createTime = new Date();
        this.updateBy = creator;
        this.updateTime = new Date();
    }

    /**
     * 添加更新人
     * @return
     */
    public void addUpdater(String updater) {
        this.updateBy = updater;
        this.updateTime = new Date();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UpmsDictDataDO{");
        sb.append("dictCode=").append(dictCode);
        sb.append(", dictSort=").append(dictSort);
        sb.append(", dictLabel='").append(dictLabel).append('\'');
        sb.append(", dictValue='").append(dictValue).append('\'');
        sb.append(", dictType='").append(dictType).append('\'');
        sb.append(", cssClass='").append(cssClass).append('\'');
        sb.append(", listClass='").append(listClass).append('\'');
        sb.append(", isDefault='").append(isDefault).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", createBy='").append(createBy).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy='").append(updateBy).append('\'');
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
