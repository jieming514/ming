package com.ming.system.domain;

import java.io.Serializable;

/**
 * @Auther: jie_ming514@163.com
 * @Date: 2018/10/16 23:23
 * @Description:
 */
public class DeptDO implements Serializable {

    private Long deptId;

    private Long parentId;

    private String name;

    private Integer orderNum;

    private Integer delFlag;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DeptDO{");
        sb.append("deptId=").append(deptId);
        sb.append(", parentId=").append(parentId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", orderNum=").append(orderNum);
        sb.append(", delFlag=").append(delFlag);
        sb.append('}');
        return sb.toString();
    }
}
