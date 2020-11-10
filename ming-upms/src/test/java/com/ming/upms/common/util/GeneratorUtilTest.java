package com.ming.upms.common.util;

import com.ming.common.utils.GeneratorUtil;
import com.ming.upms.common.BasicTest;
import org.junit.Test;


public class GeneratorUtilTest extends BasicTest {

    @Test
    public void tableToJavaTest() {
        String className = GeneratorUtil.tableToJava("upms_log","false");
        System.out.println(className);
    }


}
