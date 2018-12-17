package com.ming.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回值
 */
public class R extends HashMap<String, Object> {

    private static final Logger logger = LoggerFactory.getLogger(R.class);

    public R() {
        this.put("code",0);
        this.put("msg","操作成功");
    }

    /**
     * 失败
     * @return
     */
    public static R error() {
        return error(500,"操作失败");
    }


    public static R error(String msg) {
        return error(500,msg);
    }

    public static R error(int code, String msg) {
        logger.error(msg);
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    /**
     * 成功
     */
    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String,Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key,value);
        return this;
    }
    
}
