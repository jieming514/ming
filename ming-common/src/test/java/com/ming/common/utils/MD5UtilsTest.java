package com.ming.common.utils;


import org.junit.Assert;
import org.junit.Test;

public class MD5UtilsTest {


    @Test
    public void encryptTest() {
        String password = "admin123";
        String md5Str = MD5Utils.encrypt(password);
        Assert.assertEquals("bc9c17a2cfb75c8a4d035aecf463e7ab", md5Str);
    }

    @Test
    public void encryptTest2() {
        String username = "admin";
        String password = "admin123";
        String md5Str = MD5Utils.encrypt(username, password);
        Assert.assertEquals("d1e2292b8991e896b272a37e1c9be3ad",md5Str);
    }
}