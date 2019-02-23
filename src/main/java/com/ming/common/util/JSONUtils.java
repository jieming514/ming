package com.ming.common.util;

import com.alibaba.fastjson.JSON;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2019/2/23 21:52
 */
public class JSONUtils {
    
    
    /**
     * 功能描述: Bean转换为JSON
     *
     * @param: Bean
     * @return: json
     * @auther: jie_ming514@163.com
     * @date: 2019/2/23 21:53
     */
    public static String beanToJson(Object object) {
        if (object != null) {
            return JSON.toJSONString(object);
        }else {
            return null;
        }
    }
}
