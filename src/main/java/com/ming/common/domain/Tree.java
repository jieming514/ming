package com.ming.common.domain;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tree<T> {

    /**
     * 节点 ID
     */
    private String id;

    /**
     * 节点描述
     */
    private String text;

    /**
     * 节点状态
     */
    private Map<String, Object> state;

    /**
     * 是否被选中
     */
    private boolean checked = false;

    /**
     * 属性
     */
    private Map<String, Object> attributes;

    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * 是否有父节点
     */
    private boolean hasParent = false;

    /**
     * 子节点
     */
    private List<Tree<T>> children = new ArrayList<>();

    /**
     * 是否有子节点
     */
    private boolean hasChildren = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public void setHasParent(boolean hasParent) {
        this.hasParent = hasParent;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
