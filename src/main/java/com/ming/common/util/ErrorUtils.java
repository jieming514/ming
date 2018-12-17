package com.ming.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 错误工具类
 * @Auther: jie_ming514@163.com
 * @Date: 2018/12/17 23:47
 */
public class ErrorUtils {



    private static int MAX_ERROR_NUM = 9;

    private static int MIN_ERROR_NUM = 0;

    /**
     * 功能描述: 生成错误码
     *
     * @param: 错误级别
     * @return: 错误码
     * @auther: jie_ming514@163.com
     * @date: 2018/12/17 23:51
     */
    public static String makeErrorCode(int level) {
        String time = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
        level = level > MAX_ERROR_NUM ? MAX_ERROR_NUM : level;
        level = level > MIN_ERROR_NUM ? MIN_ERROR_NUM : level;

        StringBuffer errorCode = new StringBuffer();
        errorCode.append("E")
                .append(level)
                .append("-")
                .append(time);
        return errorCode.toString();
    }


    public static String makeErrorCode() {
        return makeErrorCode(1);
    }

}
