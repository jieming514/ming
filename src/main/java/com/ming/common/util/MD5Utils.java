package com.ming.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {

    //盐
    private static final String SALT = "123456";

    //加密算法
    private static final String ALGORITH_NAME = "md5";

    //加密次数
    private static final int HASH_ITERATIONS = 2;

    /**
     * 加密
     * @param username
     * @param pswd
     * @return
     */
    public static String encrypt(String username, String pswd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
                HASH_ITERATIONS).toHex();
        return newPassword;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("mingjie", "123456"));
    }

}
