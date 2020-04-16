package com.ming.upms.common.util;

import com.ming.upms.common.BasicTest;
import com.ming.upms.common.dao.GeneratorDao;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;


public class GeneratorUtilTest extends BasicTest {

    @Test
    public void tableToJavaTest() {
        String className = GeneratorUtil.tableToJava("upms_log","false");
        System.out.println(className);
    }


}
