package com.ming.upms.common.service.impl;

import com.ming.upms.common.dao.GeneratorDao;
import com.ming.upms.common.service.GeneratorService;
import com.ming.upms.common.util.GeneratorUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service("generatorService")
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private GeneratorDao generatorDao;

    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for(String tableName : tableNames){
            //查询表信息
            Map<String, String> table = generatorDao.get(tableName);
            //查询列信息
            List<Map<String, String>> columns = generatorDao.listColumns(tableName);
            //生成代码
            GeneratorUtil.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    @Override
    public List<Map<String, Object>> list() {
        return generatorDao.list();
    }

    @Override
    public int count(Map<String, Object> map) {
        return generatorDao.count(map);
    }

    @Override
    public Map<String, String> get(String tableName) {
        return generatorDao.get(tableName);
    }

    @Override
    public List<Map<String, String>> listColumns(String tableName) {
        return generatorDao.listColumns(tableName);
    }
}
