package com.ming.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 * @author jie_ming514
 */
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 每页其实编号， 默认第一页
      */
    private int offset = 1;

    /**
     * 每页条数, 默认10条
     */
    private int limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        this.offset = Integer.parseInt(params.get("offset").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("offset", offset);
        this.put("page", offset / limit + 1);
        this.put("limit", limit);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.put("offset", offset);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
