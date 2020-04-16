package com.ming.upms.common.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface GeneratorService {

    byte[] generatorCode(String[] tableNames);

    List<Map<String, Object>> list();

    int count(Map<String, Object> map);

    Map<String, String> get(String tableName);

    List<Map<String, String>> listColumns(String tableName);
}
