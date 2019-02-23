package com.ming.common.util;

/**
 * @Description: ${desc}
 * @Auther: jie_ming514@163.com
 * @Date: 2019/2/23 20:15
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    private static final int DEFAULT_BEGIN_INDEX = 0;

    private static final int DEFAULT_LENGTH = 200;


    public static String limit(String paramStr) {
        return limit(paramStr, DEFAULT_LENGTH);
    }

    /**
     * 功能描述: 截取字符串长度
     *
     * @param: paramStr  源字符串;   count   长度
     * @return: 目标转化字符串
     * @auther: jie_ming514@163.com
     * @date: 2019/2/23 21:50
     */
    public static String limit(String paramStr, int count) {
        if(paramStr.length() < count) {
            count = paramStr.length();
        }
        return substring(paramStr, DEFAULT_BEGIN_INDEX ,count);
    }


}
